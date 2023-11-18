package Component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class KeyListenerTest extends JFrame implements KeyListener {
    JLabel l1;
    JTextArea area;

    public KeyListenerTest() {
        setTitle("Key Listener");
        setSize(400, 400);
        setLayout(null);
        l1 = new JLabel("Test");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setSize(400, 30);
        area = new JTextArea();
        area.setSize(300, 200);
        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(100, 100, 300, 200);
        area.addKeyListener(this);
        add(l1);
        add(sp);
        setVisible(true);

    }

    public static void main(String[] args) {
        new KeyListenerTest();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        l1.setText("Typing....");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        l1.setText("Pressing...."); // click shift

    }

    @Override
    public void keyReleased(KeyEvent e) {
        l1.setText("Releasing....");

    }
}