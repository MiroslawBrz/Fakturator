package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    public void addClientWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/ClientWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Wprowadź dane klienta");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
