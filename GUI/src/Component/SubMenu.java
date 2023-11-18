package Component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SubMenu implements ActionListener {
	JMenuBar mb;
	JFrame f;
	JMenu file, importfile;
	JMenuItem op1, op2, open;
	JTextArea area;

	public SubMenu() {
		JFrame f = new JFrame("Menu Bar");
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mb = new JMenuBar();
		file = new JMenu("File");
		importfile = new JMenu("Import File");
		open = new JMenuItem("Open");
		file.add(open);
		file.add(importfile);
		op1 = new JMenuItem("Import Document");
		op2 = new JMenuItem("Import Image");
		importfile.add(op1);
		importfile.add(op2);
		mb.add(file);
		f.setJMenuBar(mb);
		area = new JTextArea();
		JScrollPane jsp = new JScrollPane(area);
		f.add(jsp, BorderLayout.CENTER);
		open.addActionListener(this);

		f.setVisible(true);
	}

	public static void main(String[] args) {
		new SubMenu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == open) {
			JFileChooser fc = new JFileChooser();
			int i = fc.showOpenDialog(f);
			if (i == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				String path = file.getPath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(path));
					String s1;
					String allString = "";
					while ((s1 = br.readLine()) != null) {

						allString += s1 + "\n";
					}
					area.append(allString);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		}

	}
}
