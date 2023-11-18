package JDBCTest;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getConnection();
        System.out.println("Connection Successful");
        Statement st = con.createStatement();
        String query = "update testtable set name='Mika' where id=113";
        st.executeUpdate(query);
        System.out.println("Update Successful");
        ResultSet rs = st.executeQuery("Select * from testTable");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
        }
    }
}