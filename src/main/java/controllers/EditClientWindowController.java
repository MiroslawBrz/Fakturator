package controllers;

import data.Company;
import data.DBConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditClientWindowController {

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
    private Button closeWindow;
    @FXML
    private Label infoAfterUpdate;

    public void closeButtonAction(){
        Stage stage = (Stage) closeWindow.getScene().getWindow();
        stage.close();
    }

    public void initialize(){
        this.companyName.textProperty().setValue(Company.COMPANY_NAME);
        this.companyNIP.textProperty().setValue(Company.sNIP);
        this.companyCity.textProperty().setValue(Company.COMPANY_CITY);
        this.companyPostalCode.textProperty().setValue((Company.COMPANY_POSTALCODE));
        this.companyStreet.textProperty().setValue(Company.COMPANY_STREET);
        this.companyNIP.setDisable(true);
    }

    public void updateCompany() {
        String name = companyName.getText();
        String NIP = companyNIP.getText();
        String street = companyStreet.getText();
        String postalCode = companyPostalCode.getText();
        String city = companyCity.getText();
        DBConnector.CompanyToDB companyToDB = new DBConnector.CompanyToDB();
        companyToDB.updateNewCompany(name, street, postalCode, city, NIP);
        infoAfterUpdate.setText(companyToDB.messege);
    }

}
