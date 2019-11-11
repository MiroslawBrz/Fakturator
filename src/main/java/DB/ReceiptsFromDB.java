package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiptsFromDB {

    public static List<Receipt> receiptsList = new ArrayList<>();

    public List getProductsFromDBToSingleReceipt(int receiptID) {
        List<Product> productsList = null;
        String sqlQuery = "SELECT * FROM RecPar JOIN Products ON RecPar.ProductID = Products.ID JOIN Receipts ON RecPar.ReceiptID = Receipts.ID WHERE Receipts.ID = " + receiptID + ";";
        try {
            Statement statement = DBConnector.CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                productsList.add(new Product(resultSet.getInt(4), resultSet.getLong(5), resultSet.getString(6), resultSet.getDouble(7), resultSet.getDouble(8), resultSet.getInt(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productsList;
    }

    public static void getReceiptsListFromDB(){
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
                }
                receiptsList.add(new Receipt(i, date, grossValue));
            }
       }
       catch (SQLException ex){
           ex.printStackTrace();
       }
    }

    private static int getReceiptTableSize() {
        String sqlQuery = "SELECT COUNT (*) FROM RecPar";
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
