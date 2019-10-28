package data;

import org.json.JSONObject;

public class JSON {

    private String companyName;
    private String companyStreet;
    private String companyBuildingNumber;
    private String companyCity;
    private String companyPostalCode;

    CURL curl = new CURL();


    public void getJson(){
        curl.getDataFromApiByNIP();
        String json = curl.getResult();
        System.out.println(json);

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

    public String getCompanyBuildingNumber() {
        return companyBuildingNumber;
    }

    public void setCompanyBuildingNumber(String companyBuildingNumber) {
        this.companyBuildingNumber = companyBuildingNumber;
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
