package WindowAndFrame;

import javax.swing.JWindow;

public class WindowTest {
 public WindowTest() {
	JWindow w = new JWindow();
	w.setSize(400,400);
	w.setLocation(100, 100 );
	w.setVisible(true);
}
 public static void main(String[] args) {
	new WindowTest();
}
}
