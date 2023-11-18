package Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JMenuBarTest {
    JMenuBar mb;
    JMenu file, edit;
    JMenuItem new1, close, open, copy, cut, paste;

    public JMenuBarTest() {
        JFrame f = new JFrame("Menu Bar");
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mb = new JMenuBar();
        // Add file Menu
        file = new JMenu("File");
        new1 = new JMenuItem("New");
        close = new JMenuItem("Close");
        open = new JMenuItem("Open");
        new1.setIcon(new ImageIcon(ClassLoader.getSystemResource("new.png")));
        open.setIcon(new ImageIcon(ClassLoader.getSystemResource("open.png")));
        close.setIcon(new ImageIcon(ClassLoader.getSystemResource("close.png")));
        file.add(new1);
        file.add(open);
        file.addSeparator();
        file.add(close);

        mb.add(file);

        // Add edit Menu
        edit = new JMenu("Edit");
        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        copy.setIcon(new ImageIcon(ClassLoader.getSystemResource("copy.png")));
        cut.setIcon(new ImageIcon(ClassLoader.getSystemResource("cut.png")));
        paste.setIcon(new ImageIcon(ClassLoader.getSystemResource("paste.png")));
        edit.add(copy);
        edit.add(cut);
        edit.addSeparator();
        edit.add(paste);
        mb.add(edit);

        f.setJMenuBar(mb);
        f.setVisible(true);
        // With photo Scale
        // ImageIcon newl1 = new ImageIcon(ClassLoader.getSystemResource("new.png"));
        // Image newScaled = newl1.getImage().getScaledInstance(15, 15,
        // Image.SCALE_DEFAULT);
        // ImageIcon scaledIcon = new ImageIcon(newScaled);
    }

    public static void main(String[] args) {
        new JMenuBarTest();
    }
}
