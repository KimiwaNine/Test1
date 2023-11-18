package Component;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenmonicMenuBar implements ActionListener {
    JMenuBar mb;
    JMenu m;
    JMenuItem print, ppriew, exit;

    public MenmonicMenuBar() {
        JFrame f = new JFrame("Menmonic Menu Bar");
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mb = new JMenuBar();
        m = new JMenu("File");
        print = new JMenuItem("Print");
        ppriew = new JMenuItem("Print Preview");
        exit = new JMenuItem("Exit");

        m.add(print);
        m.add(ppriew);
        m.addSeparator();
        m.add(exit);
        mb.add(m);

        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
        ppriew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK + Event.SHIFT_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));

        print.addActionListener(this);
        ppriew.addActionListener(this);
        exit.addActionListener(this);
        f.setJMenuBar(mb);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new MenmonicMenuBar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

    }
}