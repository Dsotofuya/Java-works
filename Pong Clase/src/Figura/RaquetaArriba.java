package Figura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import GUI.PanelObjects;

public class RaquetaArriba implements Figura {

		private int x = 0;

		private int xAceleration = 0;
		
		private static final int Y = 50;
		private static final int WITH = 100;
		private static final int HeiGHT = 25;
		
		
		
		private PanelObjects panelObjects;
		

		public RaquetaArriba(PanelObjects panelObjects) {
		 this.panelObjects = panelObjects;
		}
		
		@Override
		public void mover() {
			if (x + xAceleration > 0 && x + xAceleration < panelObjects.getWidth()-100) {
				x = x + xAceleration;
			}		
		}

		@Override
		public void paint(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(x, Y, WITH, HeiGHT);

			
		}

		public void KeyReleased(KeyEvent e) {
			xAceleration = 0;
		}
		
		public void KeyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				xAceleration = -5;
			} if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				xAceleration = 5;
			}
		}
		
		public Rectangle obtenerBordes() {
			return new Rectangle(x, Y, WITH, HeiGHT);
		}
		
		public int getBotY(){
			return Y + HeiGHT;
		}

		public void setX(int x) {
			this.x = x;
		}
		
}
