package Figura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import GUI.PanelObjects;

public class Pelota implements Figura {

	private PanelObjects panelObjects;
	private int x = 50;
	private int xA = 1;
	private int y = 50;
	private int yA = 1;
	private int points = -1;
	private static final int Diameter = 30;
		
	public Pelota(PanelObjects panelObjects) {
		this.panelObjects = panelObjects;
	}
	
	@Override
	public void mover() {
		if (x + xA < 0) {
			xA = 5;
		} if (x + xA > panelObjects.getWidth() - Diameter) {
			xA = -5;
		} if (y + yA < 35) {
//			yA = 5;
			panelObjects.gameOver();
		} if (y + yA > panelObjects.getHeight() - Diameter) {
//			yA = -1;
			panelObjects.gameOver();
		} if (colisionRaquetaAbajo() ) {
			yA= -5;
			y = panelObjects.getRaquetaAbajo().getTopY() - Diameter;
			points++;
			panelObjects.setPuntos(points);
		} if (colisionRaquetaArriba()) {
			yA = 5;
			y = panelObjects.getRaquetaArriba().getBotY() + Diameter;
			points++;
			panelObjects.setPuntos(points);
		}
		x = x + xA;
		y = y + yA;
 	}

	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillOval(x, y, 30, 30);
	}
	
	public boolean colisionRaquetaAbajo() {
		return panelObjects.getRaquetaAbajo().obtenerBordes().intersects(getBordes());
	}
	
	public boolean  colisionRaquetaArriba() {
		return panelObjects.getRaquetaArriba().obtenerBordes().intersects(getBordes());
	}
	
	public Rectangle getBordes() {
		return new Rectangle(x, y, Diameter, Diameter);
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setxA(int xA) {
		this.xA = xA;
	}

	public void setyA(int yA) {
		this.yA = yA;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
