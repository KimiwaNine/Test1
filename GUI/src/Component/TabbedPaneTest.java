package Component;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TabbedPaneTest {
    JTabbedPane tb;
    JPanel p1, p2, p3;

    public TabbedPaneTest() {
        JFrame f = new JFrame("Tab Pane");
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createP1();
        createP2();
        createP3();

        tb = new JTabbedPane();
        tb.add("Page1", p1);
        tb.add("Page2", p2);
        tb.add("Page3", p3);
        f.add(tb);
        f.setVisible(true);
    }

    private void createP3() {

    	p3 = new JPanel();
        p3.setLayout(new GridLayout(3, 2));
        p3.add(new JLabel("Field 1"));
        p3.add(new JTextArea());
        p3.add(new JLabel("Field 2"));
        p3.add(new JTextArea());
        p3.add(new JLabel("Field 3"));
        p3.add(new JTextArea());
    }   

    private void createP2() {

        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        
        p2.add(new JButton("North Button"),BorderLayout.NORTH);
        p2.add(new JButton("East Button"),BorderLayout.EAST);
        p2.add(new JButton("South Button"),BorderLayout.SOUTH);
        p2.add(new JButton("West Button"),BorderLayout.WEST);
        p2.add(new JButton("Center Button"),BorderLayout.CENTER);
    }

    private void createP1() {
        p1 = new JPanel();
        p1.setLayout(null);
        JLabel l1 = new JLabel("User Name");
        l1.setBounds(10, 20, 150, 30);
        p1.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(10, 50, 150, 30);
        p1.add(t1);
        JLabel l2 = new JLabel("Password");
        l2.setBounds(10, 80, 150, 30);
        p1.add(l2);

        JPasswordField p = new JPasswordField();
        p.setBounds(10, 110, 150, 30);
        p1.add(p);
    }

    public static void main(String[] args) {
        new TabbedPaneTest();
    }
}
