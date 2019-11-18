package controllers;
import data.*;
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
    private Button getInvoiceButton;
    @FXML
    private Label infoAfterAddReceipt;

    private ObservableList<Receipt> data = FXCollections.observableArrayList();

    private Receipt receipt;
    private ReceiptsFromDB receiptsFromDB = new ReceiptsFromDB();
    private InvoiceToDB invoiceToDB = new InvoiceToDB();

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
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        for(Receipt r : ReceiptsFromDB.receiptsList){
            if(r.getReceiptID() == receiptID){
                receipt = r;
            }
        }
        if(receipt==null){
            infoAfterAddReceipt.setText("Nie znaleziono paragonu o podanym numerze");
        }
        else{
            infoAfterAddReceipt.setText("Poprawnie dodano paragon");
        }
        getInvoiceButton.setDisable(false);
    }

    public void addInvoice(){
        Invoice invoice = new Invoice(receipt, new Company(Company.sNIP, Company.COMPANY_NAME, Company.COMPANY_STREET, Company.COMPANY_CITY, Company.COMPANY_POSTALCODE));
        InvoiceList.invoices.add(invoice);
        invoiceToDB.addInvoiceToDB(invoice);
    }
}
