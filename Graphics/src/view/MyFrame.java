package view;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	private static final long serialVersionUID = -7512227042723393114L;
	
//	private graphicPanel graphic;
	private graphic2DPanel graphic2d;
	public MyFrame() {
		setSize(800,600);
		graphic2d = new graphic2DPanel();
//		graphic = new graphicPanel();
		add(graphic2d);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
