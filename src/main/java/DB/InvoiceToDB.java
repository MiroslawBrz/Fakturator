package DB;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class InvoiceToDB {

    public void addInvoiceToDB(Invoice invoice){
        String companyID = invoice.getCompany().getNIP();
        LocalDate invoiceDate = LocalDate.now();
        int receiptID = invoice.getReceipt().getReceiptID();
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Invoices ([InvoiceDate],[CompanyID],[ReceiptID])").append("VALUES")
         .append("(\'" + invoiceDate + "\',\'")
                .append(companyID + "\',\'").append(receiptID + "\')");
        String url = sb.toString();
        try{
        Statement statement = DBConnector.CONNECTION.createStatement();
        statement.execute(url);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
