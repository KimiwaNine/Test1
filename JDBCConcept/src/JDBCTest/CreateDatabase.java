package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        Connection con;
        Statement stm;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
            System.out.println("Connection Successful");
            stm = con.createStatement();
            stm.execute("create database javadatabase");
            System.out.println("Created Databases");
            stm.execute("use javadatabase");
            System.out.println("Use your database");

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Connection Fail");
        }

    }
}