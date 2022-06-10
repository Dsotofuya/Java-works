package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class graphic2DPanel extends JPanel{
	private static final long serialVersionUID = 7830242425383415092L;

	public graphic2DPanel() {
	
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
// 		g2d.setComposite(); efectos
//		g2d.transform(Tx); girar imagen
		g2d.fillOval(50, 50, 100, 100);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(50, 200, 100, 100);
	}
}
