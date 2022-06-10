package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class CanvasPanel extends JPanel {
	private static final long serialVersionUID = -9218208369265382035L;

	private Graphics2D graphics2d;
	private BufferedImage image;
	
	public CanvasPanel() {
		setPreferredSize(new Dimension(400, 300));
		setBorder(BorderFactory.createLineBorder(Color.darkGray));
		image = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
		graphics2d = image.createGraphics();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		graphics2d.drawImage(image, 0, 0, this);
		g.drawImage(image, 0, 0, this);
	}

	public void  paintImage(Color[][] image) {
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				for (int j = 0; j < image.length; j =  j+2) {
					for (int i = 0; i < image.length; i= i+2) {
						repaint();
						System.out.println("pintando");
						graphics2d.setColor(image[i][j]);
						graphics2d.drawRect(i, j, 1, 1);
						Thread.sleep(50);
					}
				}
				System.out.println("done");
				return null;
			}
		};
		worker.execute();
	}
}
