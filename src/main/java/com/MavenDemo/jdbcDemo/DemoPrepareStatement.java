package com.MavenDemo.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoPrepareStatement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userName = "system";
        String password = "dhinesh";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(url, userName, password);

         
            // Prepare the SQL statements
            String Sql_select = "select * from DATABASE.AGENT";
            String Sql_insert = "INSERT INTO DATABASE.AGENT VALUES("+val+","+name+","+city+")";

            
            ResultSet testRecord = con.prepareStatement(Sql_insert).executeQuery(Sql_select);
            while (testRecord.next()) {
                System.out.println(testRecord.getString(1) + " " + testRecord.getString(2) + " " + testRecord.getString(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Close the scanner
            // Close the resources in reverse order of creation
            // This ensures that even if one of them throws an exception, the others are still closed
            // Closing in reverse order prevents potential resource leaks.
           
    }
}
}
