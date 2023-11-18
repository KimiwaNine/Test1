package Exercises;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex_2_Search implements ActionListener {
    JLabel l1, l2, l3;
    JTextField fname, lname;
    JButton query;
    JPanel p1;
    JTable tb;
    Object[] row;

    public Ex_2_Search() {
        JFrame f = new JFrame("Search Box");
        f.setSize(600, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new JLabel("User Profile");
        l1.setFont(new Font("Time New Roman", Font.BOLD, 14));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setSize(600, 30);
        p1 = new JPanel();
        p1.add(new JLabel("First Name"));
        p1.setBounds(0, 40, 600, 50);
        fname = new JTextField();
        fname.setPreferredSize(new Dimension(150, 30));
        p1.add(fname);

        p1.add(new JLabel("Last Name"));
        lname = new JTextField();
        lname.setPreferredSize(new Dimension(150, 30));
        p1.add(lname);
        query = new JButton("Query");
        p1.add(query);
        tb = new JTable();
        JScrollPane jsp = new JScrollPane(tb);
        jsp.setBounds(30, 100, 500, 300);

        tb.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "ActorID", "FirstName", "LastName", "LastUpdate" }));
        f.add(l1);
        f.add(p1);
        f.add(jsp);
        query.addActionListener(this);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new Ex_2_Search();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Connection con;
        PreparedStatement pst;
        Statement st;
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/search", "root", "root");
            System.out.println("Connection Successful");
            // pst = con.prepareStatement("Select * from actorprofile where lastname =
            // 'Pe%'");
            // pst.execute();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from actorprofile where firstname like 'Pe%' ");
            while (rs.next()) {
                row = new Object[tb.getColumnCount()];
                System.out.println(row.length);
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                model.addRow(row);
            }

        } catch (Exception e1) {

            e1.printStackTrace();
        }
	}
}
