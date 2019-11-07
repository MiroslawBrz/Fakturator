package data;

import application.DBConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyToDB {
    public String messege = "";
    public void saveNewCompany(String name, String street, String postalCode, String city, String NIP)  {
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
        catch(SQLException ex ){
            messege= "Firma o podanym nipie jest jest już w bazie";
        }





    }

}

