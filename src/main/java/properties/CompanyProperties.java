package properties;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CompanyProperties {

    private StringProperty companyNameProperty = new SimpleStringProperty();
    private StringProperty companyStreetProperty = new SimpleStringProperty();
    private StringProperty companyCityProperty = new SimpleStringProperty();
    private StringProperty companyPostalCodeProperty = new SimpleStringProperty();
    private StringProperty companyNIP = new SimpleStringProperty();
    private BooleanProperty companyNameOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty companyStreetOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty companyCityOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty companyPostalCodeOKProperty = new SimpleBooleanProperty(false);
    private BooleanProperty companyNIPOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty buttonProperty = new SimpleBooleanProperty(false);
    private BooleanProperty buttonFindProperty = new SimpleBooleanProperty(false);

    public CompanyProperties(){
        companyNameOkProperty.bind(companyNameProperty.isNotEmpty());
        companyStreetOkProperty.bind(companyStreetProperty.isNotEmpty());
        companyCityOkProperty.bind(companyCityProperty.isNotEmpty());
        companyPostalCodeOKProperty.bind(companyPostalCodeProperty.isNotEmpty());
        companyNIPOkProperty.bind(companyNIP.length().isEqualTo(10));
        buttonProperty.bind(companyNameProperty.isEmpty().or(companyStreetProperty.isEmpty().or(companyCityProperty.isEmpty().or(companyPostalCodeProperty.isEmpty().or(companyNIP.isEmpty())))));
        buttonFindProperty.bind(companyNIPOkProperty.not());
    }


    public StringProperty getCompanyNameProperty() {
        return companyNameProperty;
    }
    public void setCompanyNameProperty(String companyNameProperty) {
        this.companyNameProperty.set(companyNameProperty);
    }
    public StringProperty getCompanyStreetProperty() {
        return companyStreetProperty;
    }
    public void setCompanyStreetProperty(String companyStreetProperty) {
        this.companyStreetProperty.set(companyStreetProperty);
    }
    public StringProperty getCompanyCityProperty() {
        return companyCityProperty;
    }
    public void setCompanyCityProperty(String companyCityProperty) {
        this.companyCityProperty.set(companyCityProperty);
    }
    public StringProperty getCompanyPostalCodeProperty() {
        return companyPostalCodeProperty;
    }
    public void setCompanyPostalCodeProperty(String companyPostalCodeProperty) {
        this.companyPostalCodeProperty.set(companyPostalCodeProperty);
    }
    public StringProperty getCompanyNIP() {
        return companyNIP;
    }
    public void setCompanyNIP(String companyNIP) {
        this.companyNIP.set(companyNIP);
    }
    public BooleanProperty isCompanyNameOkProperty() {
        return companyNameOkProperty;
    }
    public void setCompanyNameOkProperty(boolean companyNameOkProperty) {
        this.companyNameOkProperty.set(companyNameOkProperty);
    }
    public BooleanProperty isCompanyStreetOkProperty() {
        return companyStreetOkProperty;
    }
    public void setCompanyStreetOkProperty(boolean companyStreetOkProperty) {
        this.companyStreetOkProperty.set(companyStreetOkProperty);
    }
    public BooleanProperty isCompanyCityOkProperty() {
        return companyCityOkProperty;
    }
    public void setCompanyCityOkProperty(boolean companyCityOkProperty) {
        this.companyCityOkProperty.set(companyCityOkProperty);
    }
    public BooleanProperty isCompanyPostalCodeOKProperty() {
        return companyPostalCodeOKProperty;
    }
    public void setCompanyPostalCodeOKProperty(boolean companyPostalCodeOKProperty) {
        this.companyPostalCodeOKProperty.set(companyPostalCodeOKProperty);
    }
    public BooleanProperty isCompanyNIPOkProperty() {
        return companyNIPOkProperty;
    }
    public void setCompanyNIPOkProperty(boolean companyNIPOkProperty) {
        this.companyNIPOkProperty.set(companyNIPOkProperty);
    }
    public BooleanProperty isButtonProperty() {
        return buttonProperty;
    }
    public void setButtonProperty(boolean buttonProperty) {
        this.buttonProperty.set(buttonProperty);
    }


    public BooleanProperty isButtonFindProperty() {
        return buttonFindProperty;
    }

    public void setButtonFindProperty(boolean buttonFindProperty) {
        this.buttonFindProperty.set(buttonFindProperty);
    }
}
