package DB;
import java.util.Date;
import java.util.List;


public class Receipt {

    private Date receiptDate;
    private int receiptID;
    private double receiptValue;


    public Receipt(int receiptID, Date receiptDate, double receiptValue, List<Product> productList) {
        this.receiptID = receiptID;
        this.receiptDate = receiptDate;
        this.receiptValue = receiptValue;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public double getReceiptValue() {
        return receiptValue;
    }

    public void setReceiptValue(double receiptValue) {
        this.receiptValue = receiptValue;
    }
}
