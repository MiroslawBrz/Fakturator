package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public static Connection CONNECTION;

    private static String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=fakturator;integratedSecurity=true;";

    public static Connection connect(){
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try {
            CONNECTION = DriverManager.getConnection(JDBC_URL);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return CONNECTION;
    }


}
