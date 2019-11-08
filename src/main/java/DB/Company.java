package DB;

import javafx.beans.property.SimpleStringProperty;


public class Company {

    private String NIP;
    private String companyName;
    private String companyStreet;
    private String companyCity;
    private String companyPostalCode;

    public static String sNIP;
    public static String COMPANY_NAME;
    public static String COMPANY_STREET;
    public static String COMPANY_CITY;
    public static String COMPANY_POSTALCODE;

    public Company(){

    }

    public Company(String NIP, String companyName, String companyStreet, String companyCity, String companyPostalCode) {
        this.NIP = NIP;
        this.companyName = companyName;
        this.companyStreet = companyStreet;
        this.companyCity = companyCity;
        this.companyPostalCode = companyPostalCode;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
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
}
