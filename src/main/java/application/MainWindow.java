package application;

import DB.CompanyFromDB;
import DB.DBConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    public static void main(String[] args)  {

       DBConnector.connect();
       launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/MainWindow.fxml"));
        primaryStage.setTitle("Fakturator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
