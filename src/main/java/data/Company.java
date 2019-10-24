package data;

public class Company {

    private String companyName;
    private String companyStreet;
    private String companyCity;
    private String companyPostalCode;
    private String companyNIP;

    public Company(String companyName, String companyStreet, String companyCity, String companyPostalCode, String companyNIP) {
        this.companyName = companyName;
        this.companyStreet = companyStreet;
        this.companyCity = companyCity;
        this.companyPostalCode = companyPostalCode;
        this.companyNIP = companyNIP;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyStreet() {
        return companyStreet;
    }

    public void setCompanyStreet(String companyStreet) {
        this.companyStreet = companyStreet;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyPostalCode() {
        return companyPostalCode;
    }

    public void setCompanyPostalCode(String companyPostalCode) {
        this.companyPostalCode = companyPostalCode;
    }

    public String getCompanyNIP() {
        return companyNIP;
    }

    public void setCompanyNIP(String companyNIP) {
        this.companyNIP = companyNIP;
    }

    @Override
    public String toString() {
        return "Firma " + companyName + " została poprawnie wprowadzona";
    }
}
