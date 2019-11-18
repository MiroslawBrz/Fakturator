package DB;

public class Product {

    private int productID;
    private long EAN;
    private String productName;
    private double purchasePrice;
    private double netPrice;
    private int vat;

    public Product(int productID, long EAN, String productName, double purchasePrice, double netPrice, int vat) {
        this.productID = productID;
        this.EAN = EAN;
        this.productName = productName;
        this.purchasePrice = purchasePrice;
        this.netPrice = netPrice;
        this.vat = vat;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public long getEAN() {
        return EAN;
    }

    public void setEAN(long EAN) {
        this.EAN = EAN;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }
}
