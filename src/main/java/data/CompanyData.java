package data;

public class CompanyData {

    private String name;
    private String street;
    private String city;
    private String postalCode;
    private String NIP;

    public CompanyData(String name, String street, String city, String postalCode, String NIP) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.NIP = NIP;
    }

    @Override
    public String toString() {
        return name;
    }


}
