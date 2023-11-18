package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    static Connection con;

    public static void main(String[] args) {
        try {
            ConnectDatabase conn = new ConnectDatabase();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
            con = conn.getConnection();
            System.out.println("Connection Successful");
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Connection Fail");
        }
    }
}