package Paint;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TankPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Tank tank;
	
	public TankPanel() {
		tank = new Tank(this);
	}
	
	public Tank getTank() {
		return tank;
	}

	public void move() {
		tank.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		tank.paint(g);
	}
}
