package WindowAndFrame;

import java.awt.Frame;

public class AWT_Frame_Test {
public AWT_Frame_Test() {
	Frame f = new Frame();
	f.setTitle("AWT Frame");
	f.setSize(400,400);
	f.setLayout(null);
	f.setVisible(true);
}
public static void main(String[] args) {
	new AWT_Frame_Test();
}
}
