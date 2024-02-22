package com.MavenDemo.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionDemo {

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        
        String url="jdbc:oracle:thin:@localhost:1521:xe"; 
        String userName="system";
        String password="dhinesh";
        //step 1 registering the driver
        //String Sql_queries="CREATE TABLE DATABASE.Agent(agent_code VARCHAR2(6) NOT NULL,agent_name VARCHAR2(26) NOT NULL, working_area VARCHAR2(26) NOT NULL)";
		final String Sql_select ="select * from DATABASE.AGENT";
		final String Sql_insert="INSERT INTO DATABASE.AGENT VALUES('9','SANJAY','SALEM')";
        final String updateQuery = "UPDATE DATABASE.AGENT SET working_area='maldevs' WHERE agent_code='7' ";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //step 2 create connection
            
            Connection con = DriverManager.getConnection(url,userName,password);
            Statement stat= con.createStatement();
            //boolean isCreated=stat.execute(Sql_queries);
//    		boolean isCreated=stat.execute(Sql_select);
//    		if(isCreated) {
//    			System.out.println("table created");
//    		}
//    		else {
//    			System.out.println("not created");
//    		}
//            if(con==null) {
//                System.out.println("connection not established");
//            }
//            else {
//                System.out.println("connected");
//            }
            int rows_updated = stat.executeUpdate(updateQuery);
    		if(rows_updated>0) {
    			System.out.println("records updated");
    		}
    		else {
    			System.out.println("not updated");
    		}
            ResultSet testRecord=stat.executeQuery(Sql_select);
    		while(testRecord.next()) {
    			System.out.println(testRecord.getString(1)+" "+testRecord.getString(2)+" "+testRecord.getString(3));
    		}
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
                
    }

}
