package com.MavenDemo.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HrDatabase {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userName = "system";
        String password = "dhinesh";
        String query = "update DATABASE1.employees SET salary = 18000 WHERE department_id = 90 AND job_id = 'AD_VP'";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: create connection
            try (Connection con = DriverManager.getConnection(url, userName, password);
                 Statement stat = con.createStatement()) {

                int rows_updated = stat.executeUpdate(query);
                if (rows_updated > 0) {
                    System.out.println("updated");
                } else {
                    System.out.println("not updated");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
