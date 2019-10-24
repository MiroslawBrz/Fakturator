package controllers;

import data.Company;
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



    public void saveNewCompany(){
        Company company = new Company(companyName.getText(), companyStreet.getText(), companyCity.getText(), companyPostalCode.getText(), companyNIP.getText());
        infoAfterSave.setText(company.toString());
    }

}
