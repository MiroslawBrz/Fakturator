package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiptsFromDB {

    public static List<Receipt> receiptsList = new ArrayList<>();
    public static List<Product> productsList = new ArrayList<>();

    public void getProductsFromDBToSingleReceipt(int receiptID) {
        productsList.clear();
        String sqlQuery = "SELECT * FROM RecPar JOIN Products ON RecPar.ProductID = Products.ID JOIN Receipts ON RecPar.ReceiptID = Receipts.ID WHERE Receipts.ID = " + receiptID + ";";
        try {
            Statement statement = DBConnector.CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                productsList.add(new Product(resultSet.getInt("ID"), resultSet.getLong("EAN"), resultSet.getString("ProductName"), resultSet.getDouble("PurchasePrice"), resultSet.getDouble("NetPrice"), resultSet.getInt("Vat")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getReceiptsListFromDB(){
        receiptsList.clear();
       try {
           String sqlQuery = "SELECT * FROM RecPar JOIN Products ON RecPar.ProductID = Products.ID JOIN Receipts ON RecPar.ReceiptID = Receipts.ID where Receipts.ID = ";
           Statement statement = DBConnector.CONNECTION.createStatement();
            int tableSize = getReceiptTableSize();
            for(int i = 1; i<=tableSize; i++) {
                double grossValue = 0.0;
                String s = Integer.toString(i);
                ResultSet resultSet = statement.executeQuery(sqlQuery + s);
                Date date = null;
                while (resultSet.next()) {
                    date = resultSet.getDate("saleDate");
                    double grossProductValue = resultSet.getDouble("NetPrice") * (1 + (resultSet.getDouble("Vat") / 100));
                    grossValue = grossValue + grossProductValue;
                    grossValue = grossValue*100;
                    grossValue = Math.round(grossValue);
                    grossValue = grossValue/100;
                }
                getProductsFromDBToSingleReceipt(i);
                receiptsList.add(new Receipt(i, date, grossValue, productsList));
            }
       }
       catch (SQLException ex){
           ex.printStackTrace();
       }
    }

    private static int getReceiptTableSize() {
        String sqlQuery = "SELECT COUNT (DISTINCT ReceiptID) FROM RecPar";
        int tableSize = 0;
        try {
            Statement statement = DBConnector.CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
            tableSize = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tableSize;
    }

}
