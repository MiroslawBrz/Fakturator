package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyFromDB {

    public static List companyList = new ArrayList();

    public void getCompanyListFromDB() {
        companyList.clear();
        String sqlQuery = "Select * from Companies";
        try {
            Statement statement = DBConnector.CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                companyList.add(new Company(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }



}
