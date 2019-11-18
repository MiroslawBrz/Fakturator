package DB;

public class Invoice {

    private Receipt receipt;
    private Company company;

    public Invoice(Receipt receipt, Company company){
        this.company = company;
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
