package controllers;

import DB.Company;
import DB.CompanyFromDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import properties.CompanyProperties;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

public class MainWindowController {
    @FXML
    private TableColumn<Company, String> CompanyNIPColumn;
    @FXML
    private TableColumn<Company, String> CompanyNameColumn;
    @FXML
    private TableColumn<Company, String> companyCity;

    @FXML
    private TableView<Company> CompaniesTable;

    private ObservableList <Company> data = FXCollections.observableArrayList();


    public void initialize() {

        CompaniesTable.setItems(data);
        this.CompanyNIPColumn.setCellValueFactory(new PropertyValueFactory<>("NIP"));
        this.CompanyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        this.companyCity.setCellValueFactory(new PropertyValueFactory<>("companyCity"));
        for (Object comp : CompanyFromDB.list){
        data.add((Company) comp);
        };


    }

    public void addClientWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/ClientWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Wprowadź dane klienta");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void editClientWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/EditClientWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Wprowadź dane klienta");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
