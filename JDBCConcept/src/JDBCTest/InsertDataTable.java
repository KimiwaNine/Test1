package JDBCTest;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDataTable {
    public static void main(String[] args) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadatabase", "root", "root");
            System.out.println("Connection Successful");
            st = con.createStatement();
            //String query = "insert into testTable values(111,'John',22)";
            //String query = "insert into testTable values(112,'Jame',23),(114,'Mike',24)";
            String query = "insert into testTable values(113,'Jack',25)";
            st.executeUpdate(query);
            System.out.println("Data inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}