package JDBCTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        String query = "Delete from testTable where id=113";
        st.executeUpdate(query);
        System.out.println("Deleted data");
        ResultSet rs = st.executeQuery("Select * from testTable");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
        }
    }
}