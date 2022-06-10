package Clase;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class CuadradoBordeSuave extends JFrame {
	private static final long serialVersionUID = 1L;

	public CuadradoBordeSuave() {
		setSize(400, 400);
		getContentPane().setBackground(Color.BLACK);
		
		setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillRect(50, 50, 50, 50);
		g.setColor(Color.BLUE);
		g.drawRect(50, 50, 50, 50);
	}
	
	public static void main(String[] args) {
		new CuadradoBordeSuave();
	}
}
