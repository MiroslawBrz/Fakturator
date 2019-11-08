package controllers;
import DB.Company;
import DB.CompanyFromDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;


public class MainWindowController {
    @FXML
    private TableColumn<Company, String> CompanyNIPColumn;
    @FXML
    private TableColumn<Company, String> CompanyNameColumn;
    @FXML
    private TableColumn<Company, String> companyCity;
    @FXML
    private TableColumn<Company, String> companyStreet;
    @FXML
    private TableColumn<Company, String> companyPostalCode;
    @FXML
    private TableView<Company> CompaniesTable;
    @FXML
    private Button closeButton;
    @FXML
    private MenuItem menuItemClose;


    private ObservableList <Company> data = FXCollections.observableArrayList();


    public void initialize() {

        CompaniesTable.setItems(data);
        this.CompanyNIPColumn.setCellValueFactory(new PropertyValueFactory<>("NIP"));
        this.CompanyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        this.companyCity.setCellValueFactory(new PropertyValueFactory<>("companyCity"));
        this.companyStreet.setCellValueFactory(new PropertyValueFactory<>("companyStreet"));
        this.companyPostalCode.setCellValueFactory(new PropertyValueFactory<>("companyPostalCode"));
        refreshListFromDB();


    }

    public void refreshListFromDB(){
        for (Object comp : CompanyFromDB.list){
            data.add((Company) comp);
        }
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


    public void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
