package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ShowData {
public static void main(String[] args) {
    Connection con;
    Statement st;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadatabase", "root", "root");
        System.out.println("Connection Successful");
        st = con.createStatement();
        st.execute("Select * from testTable");
        ResultSet rs= st.executeQuery("Select * from testTable");
        System.out.println("Id\tName\tAge");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}