package controllers;

import properties.Company;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClientWindowController {

    @FXML
    private TextField companyName;

    @FXML
    private TextField companyStreet;

    @FXML
    private TextField companyCity;

    @FXML
    private TextField companyPostalCode;

    @FXML
    private TextField companyNIP;

    @FXML
    private Button saveCompany;

    @FXML
    private Label infoAfterSave;

    @FXML
    private Label companyNameLabel;

    @FXML
    private Label comapnyStreetLabel;

    @FXML
    private Label companyPostalCodeLabel;

    @FXML
    private Label companyCityLabel;

    @FXML
    private Label companyNipLabel;


    private Company company = new Company();

    public void initialize(){
        companyName.textProperty().bindBidirectional(company.getCompanyNameProperty());
        companyStreet.textProperty().bindBidirectional(company.getCompanyStreetProperty());
        companyCity.textProperty().bindBidirectional(company.getCompanyCityProperty());
        companyPostalCode.textProperty().bindBidirectional(company.getCompanyPostalCodeProperty());
        companyNIP.textProperty().bindBidirectional(company.getCompanyNIP());
        companyNameLabel.visibleProperty().bind(company.isCompanyNameOkProperty());
        comapnyStreetLabel.visibleProperty().bind(company.isCompanyStreetOkProperty());
        companyCityLabel.visibleProperty().bind(company.isCompanyCityOkProperty());
        companyPostalCodeLabel.visibleProperty().bind(company.isCompanyPostalCodeOKProperty());
        companyNipLabel.visibleProperty().bind(company.isCompanyNIPOkProperty());
        saveCompany.disableProperty().bind(company.isButtonProperty());
    }

    public void saveNewCompany(){

    }

}
