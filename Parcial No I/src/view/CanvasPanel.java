package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CanvasPanel extends JPanel {
	private static final long serialVersionUID = -9218208369265382035L;

	private String text;
	private BufferedImage background;
	
	public CanvasPanel(String text) {
		this.text = text;
		setPreferredSize(new Dimension(400, 300));
		setBorder(BorderFactory.createLineBorder(Color.darkGray));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, this);
		g.drawString(text, 10, 20);
	}

	
	public void update(String text) {
		this.text = text;
		repaint();
	}
}
