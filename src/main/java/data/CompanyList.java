package data;

import properties.Company;
import java.util.ArrayList;
import java.util.List;

public class CompanyList {

    private static List<CompanyData> companyDB = new ArrayList<CompanyData>();
    Company company = new Company();


    public CompanyData saveNewCompany() {
        String name = company.getCompanyNameProperty().toString();
        String street = company.getCompanyStreetProperty().toString();
        String city = company.getCompanyCityProperty().toString();
        String postalCode = company.getCompanyPostalCodeProperty().toString();
        String NIP = company.getCompanyNIP().toString();

        return new CompanyData(name, street, city, postalCode, NIP);
    }
    public void addCompany(){
        companyDB.add(saveNewCompany());
    }
}