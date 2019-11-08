package DB;

import javafx.scene.control.Alert;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyToDB {
    public String messege = "";
    public void saveNewCompany(String name, String street, String postalCode, String city, String NIP) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO Companies ([NIP],[companyName],[Street],[City],[PostalCode]) VALUES")
                    .append("(\'" + NIP + "\',\'")
                    .append(name + "\',\'").append(street + "\',\'")
                    .append(city + "\',\'").append(postalCode + "\')");

            String SQLCommand = sb.toString();
        try{
            Statement statement = DBConnector.CONNECTION.createStatement();
            statement.execute(SQLCommand);
            statement.close();
            messege = "Poprawnie dodano firmę do bazy";

        }
        catch(SQLException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Komunikat");
            alert.setHeaderText("Information Alert");
            String s ="Firma o podanym numerze nip znajduje się bazie. Jeśli chcesz zaktualizować dane kliknij aktualizui";
            alert.setContentText(s);
            alert.show();

        }

    }
    public void updateNewCompany(String name, String street, String postalCode, String city, String NIP){
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE Companies SET [companyName] = ").append("\'"+ name +"\'").
                    append(", [street] =").append("\'"+ city +"\'").append(", [city] =")
                    .append("\'"+ city +"\'").append(", [postalCode] =")
                    .append("\'"+ postalCode +"\'").append("WHERE [NIP] =").append("\'"+ NIP +"\'");
            String SQLCommand = sb.toString();
            try{
                Statement statement = DBConnector.CONNECTION.createStatement();
                statement.execute(SQLCommand);
                statement.close();
                messege = "Poprawnie zaktualizowano firmę";

            }catch(SQLException ex){
                ex.printStackTrace();
            }

    }



}

