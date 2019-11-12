package DB;

import java.time.LocalDate;


public class InvoiceToDB {
    public void addInvoiceToDB(Invoice invoice){
        String companyID = invoice.getCompany().getNIP();
        LocalDate invoiceDate = LocalDate.now();
        int receiptID = invoice.getReceipt().getReceiptID();
        StringBuilder sb = new StringBuilder();
    }
}
