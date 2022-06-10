package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class CanvasPanel extends JPanel {
	private static final long serialVersionUID = -9218208369265382035L;

	private Random random;
	private Graphics2D graphics2d;
	private BufferedImage image;

	public CanvasPanel() {
		setBackground(Color.decode("#7fc0c7"));
		setPreferredSize(new Dimension(600, 540));
		random = new Random();
		image = new BufferedImage(600, 540, BufferedImage.TYPE_INT_ARGB);
		graphics2d = image.createGraphics();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		graphics2d.drawImage(image, 0, 0, this);
		g.drawImage(image, 0, 0, this);
	}

	public void run(HashMap<String, Integer> words) {
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (Entry<String, Integer> entry : words.entrySet()) {
					repaint();
					int fontSize = entry.getValue() * 20;
					graphics2d.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
					graphics2d.setFont(new Font("Arial", Font.BOLD, entry.getValue() * 20));
					graphics2d.drawString(entry.getKey(), random.nextInt(getPreferredSize().width - fontSize ),
							random.nextInt(getPreferredSize().height - fontSize));
					Thread.sleep(1000);
				}
				return null;
			}
			@Override
			protected void done() {
				JOptionPane.showMessageDialog(null, "Done");
			}
		};
		worker.execute();
	}
}