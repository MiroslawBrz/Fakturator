package controllers;

import API.JSON;
import data.DBConnector;
import javafx.stage.Stage;
import properties.CompanyProperties;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ClientWindowController {

    @FXML
    private Button closeWindow;
    @FXML
    private Button updateCompanyButton;
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
    private DBConnector.CompanyToDB companyToDB = new DBConnector.CompanyToDB();
    private JSON json = new JSON();

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
        updateCompanyButton.disableProperty().bind((companyProperties.isButtonFindProperty()));
    }


    public void saveAndAddNewCompany() {
        companyToDB.saveNewCompany(companyName.getText(), companyNIP.getText(), companyPostalCode.getText(), companyCity.getText(), companyNIP.getText());
        infoAfterSave.setText(companyToDB.messege);
    }

    public void findCompanyInKRSByNIP(){
        json.getStringFromAPIbyNIPAndParseJson(companyNIP.getText());
        companyName.textProperty().bindBidirectional(json.getName());
        companyStreet.textProperty().bindBidirectional(json.getStreet());
        companyCity.textProperty().bindBidirectional(json.getCity());
        companyPostalCode.textProperty().bindBidirectional(json.getPostalCode());
    }

    public void updateCompany() {
        companyToDB.updateNewCompany(companyName.getText(), companyNIP.getText(), companyPostalCode.getText(), companyCity.getText(), companyNIP.getText());
        infoAfterSave.setText(companyToDB.messege);
    }

    public void closeButtonAction(){
        Stage stage = (Stage) closeWindow.getScene().getWindow();
        stage.close();
    }

}
