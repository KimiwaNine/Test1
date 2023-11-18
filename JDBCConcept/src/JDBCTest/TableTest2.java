package JDBCTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest2 implements ActionListener {
	JButton show;
	JButton delete;
	JTable tb;
	ConnectDatabase db = new ConnectDatabase();
	Connection con;
	Statement st;

	public TableTest2() {
		JFrame f = new JFrame("Table Test");
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		show = new JButton("Show");
		delete = new JButton("Delete");
		JPanel p = new JPanel();
		p.add(show);
		p.add(delete);
		f.add(p, BorderLayout.NORTH);
		tb = new JTable();
		JScrollPane jsp = new JScrollPane(tb);
		f.add(jsp, BorderLayout.CENTER);
		tb.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Age" }));

		show.addActionListener(this);
		delete.addActionListener(this);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TableTest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) tb.getModel();

		try {
			con = db.getConnection();
			System.out.println("Connection Successful");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (e.getSource() == show) {
			try {
				st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from testTable");

				while (rs.next()) {
					Object[] row = new Object[tb.getColumnCount()];
					// System.out.println(row.length);
					row[0] = rs.getInt(1);
					row[1] = rs.getString(2);
					row[2] = rs.getInt(3);
					model.addRow(row);

				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		} else if (e.getSource() == delete) {
			int i = tb.getSelectedRow();
			int id = Integer.parseInt(model.getValueAt(i, 0).toString());
			model.removeRow(i);
			try {
				PreparedStatement ps = con.prepareStatement("Delete from testTable where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				model.setRowCount(0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
