package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
            System.out.println("Connection Successful");
            st = con.createStatement();
            st.execute("use javadatabase");
            System.out.println("Can use database");
            String query = "create table testTable(id int,name varchar(50),age int)";
            st.execute(query);
            System.out.println("Test Table created");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}