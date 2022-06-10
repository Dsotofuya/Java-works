package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class LandscapePanel extends JPanel{
	private static final long serialVersionUID = -7609072367842009153L;

	private static final String SKY = "#2a2c2e";
	private static final String TOWER = "#313d4a";
	private static final String TOWER_2 = "#494e52";
	private static final String TOWER_3 = "#3b3d40";
	private static final String MOON = "#ebeae1";
	
	public LandscapePanel() {
		setBackground(Color.decode(SKY));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.decode(MOON));
		g2d.fillOval(500, 25, 200, 200);
		g2d.setColor(Color.decode(TOWER_2));
		g2d.fillRect(100, 150, 200, 450);
		g2d.fillRect(350, 300, 250, 300);
		g2d.setColor(Color.decode(TOWER));
		g2d.fillRect(20, 300, 100, 300);
		g2d.fillRect(250, 200, 100, 400);
		g2d.fillRect(600, 100, 150, 500);
		g2d.setColor(Color.decode(TOWER_3));
		
	}
}
