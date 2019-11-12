package controllers;
import DB.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.util.Date;

public class AddInvoiceWindowController {
    @FXML
    private TableView<Receipt> receiptTable;
    @FXML
    private TableColumn<Receipt, Integer> receiptNoTableColumn;
    @FXML
    private TableColumn<Receipt, Date> receiptDateTableColumn;
    @FXML
    private TableColumn<Receipt, Double> receiptValueColumnTable;
    @FXML
    private TextField receiptTextField;
    @FXML
    private Button addReceiptToInvoiceButton;
    @FXML
    private Button getInvoiceButton;

    private ObservableList<Receipt> data = FXCollections.observableArrayList();

    private Receipt receipt;

    public void initialize() {
        receiptTable.setRowFactory(tv -> {
            TableRow<Receipt> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {
                    receipt = row.getItem();
                    getInvoiceButton.setDisable(false);
                }
            });
            return row;
        });
        this.receiptNoTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiptID"));
        this.receiptDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiptDate"));
        this.receiptValueColumnTable.setCellValueFactory(new PropertyValueFactory<>("receiptValue"));
        ReceiptsFromDB receiptsFromDB = new ReceiptsFromDB();
        receiptsFromDB.getReceiptsListFromDB();
        data.clear();
        for(Object rec : ReceiptsFromDB.receiptsList){
            data.add((Receipt) rec);
        }
        this.receiptTable.setItems(data);
    }
    public void addReceiptToInvoice(){
        int receiptID = 0;
        try{
            receiptID = Integer.parseInt(receiptTextField.getText());
        }
        catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Komunikat");
            alert.setHeaderText("Information Alert");
            String s ="Nie istnieje paragon o podanym ID lub ID nie zostało podane";
            alert.setContentText(s);
            alert.show();
        }
        for(Receipt r : ReceiptsFromDB.receiptsList){
            if(r.getReceiptID() == receiptID){
                receipt = r;
            }
        }
        getInvoiceButton.setDisable(false);
    }

    public void addInvoice(){
        //Invoice invoice = new Invoice(receipt, new Company(Company.sNIP, Company.COMPANY_NAME, Company.COMPANY_STREET, Company.COMPANY_CITY, Company.COMPANY_POSTALCODE));
        //InvoiceList.invoices.add(invoice);
    }
}
