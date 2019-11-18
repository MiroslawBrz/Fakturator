package controllers;
import data.Company;
import data.CompanyFromDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
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
    private Button FV;
    @FXML
    private Button closeButton;
    @FXML
    private Button edit;

    private ObservableList <Company> data = FXCollections.observableArrayList();

    public void initialize() {

        this.CompanyNIPColumn.setCellValueFactory(new PropertyValueFactory<>("NIP"));
        this.CompanyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        this.companyCity.setCellValueFactory(new PropertyValueFactory<>("companyCity"));
        this.companyStreet.setCellValueFactory(new PropertyValueFactory<>("companyStreet"));
        this.companyPostalCode.setCellValueFactory(new PropertyValueFactory<>("companyPostalCode"));

        CompaniesTable.setRowFactory(tv -> {
            TableRow<Company> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {
                    Company clickedRow = row.getItem();
                    edit.setDisable(false);
                    FV.setDisable(false);
                    Company.sNIP = clickedRow.getNIP();
                    Company.COMPANY_NAME = clickedRow.getCompanyName();
                    Company.COMPANY_CITY = clickedRow.getCompanyCity();
                    Company.COMPANY_STREET = clickedRow.getCompanyStreet();
                    Company.COMPANY_POSTALCODE = clickedRow.getCompanyPostalCode();
                }
            });
            return row;
        });
    }

    public void refreshListFromDB(){

        CompanyFromDB companyFromDB = new CompanyFromDB();
        companyFromDB.getCompanyListFromDB();
        data.clear();
        for (Object comp : CompanyFromDB.companyList){
            data.add((Company) comp);
        }
        CompaniesTable.setItems(data);

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

    public void addInvoiceWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/AddInvoiceWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Wystaw fakturę vat");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

