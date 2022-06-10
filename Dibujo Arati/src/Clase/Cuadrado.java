package Clase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class Cuadrado extends JFrame {
	private static final long serialVersionUID = 1L;

	public Cuadrado() {
		setSize(400, 400);
		getContentPane().setBackground(Color.BLACK);
		
		setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.GREEN);
		g2d.drawRoundRect(50, 50, 100, 50, 25, 25);
		g2d.setColor(Color.BLUE);
//		g.drawRect(50, 50, 50, 50);
	}
	
	public static void main(String[] args) {
		new Cuadrado();
	}
}
