package controllers;

import DB.CompanyToDB;
import data.JSON;
import javafx.scene.control.MenuItem;
import properties.CompanyProperties;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

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
    @FXML
    private Button findCompanyButton;


    private CompanyProperties companyProperties = new CompanyProperties();

    public void initialize(){
        companyName.textProperty().bindBidirectional(companyProperties.getCompanyNameProperty());
        companyStreet.textProperty().bindBidirectional(companyProperties.getCompanyStreetProperty());
        companyCity.textProperty().bindBidirectional(companyProperties.getCompanyCityProperty());
        companyPostalCode.textProperty().bindBidirectional(companyProperties.getCompanyPostalCodeProperty());
        companyNIP.textProperty().bindBidirectional(companyProperties.getCompanyNIP());
        companyNameLabel.visibleProperty().bind(companyProperties.isCompanyNameOkProperty());
        comapnyStreetLabel.visibleProperty().bind(companyProperties.isCompanyStreetOkProperty());
        companyCityLabel.visibleProperty().bind(companyProperties.isCompanyCityOkProperty());
        companyPostalCodeLabel.visibleProperty().bind(companyProperties.isCompanyPostalCodeOKProperty());
        companyNipLabel.visibleProperty().bind(companyProperties.isCompanyNIPOkProperty());
        saveCompany.disableProperty().bind(companyProperties.isButtonProperty());
        findCompanyButton.disableProperty().bind((companyProperties.isButtonFindProperty()));
    }


    public void saveAndAddNewCompany() {
        String name = companyName.getText();
        String NIP = companyNIP.getText();
        String street = companyStreet.getText();
        String postalCode = companyPostalCode.getText();
        String city = companyCity.getText();
        CompanyToDB companyToDB = new CompanyToDB();
        companyToDB.saveNewCompany(name, street, postalCode, city, NIP);

        infoAfterSave.setText(companyToDB.messege);
    }

    public void findCompanyInKRSByNIP(){
        JSON json = new JSON();
        String s = companyNIP.getText();
        json.getStringFromAPIbyNIPAndParseJson(s);
        companyName.textProperty().bindBidirectional(json.getName());
        companyStreet.textProperty().bindBidirectional(json.getStreet());
        companyCity.textProperty().bindBidirectional(json.getCity());
        companyPostalCode.textProperty().bindBidirectional(json.getPostalCode());
    }




}
