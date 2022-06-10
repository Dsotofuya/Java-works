package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private Graphics2D g2;
	private BufferedImage image;
	private JLabel lb;

	public Window() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		image = new BufferedImage(1000, 500, BufferedImage.TYPE_INT_ARGB);
		g2 = image.createGraphics();
		
		lb = new JLabel();
		lb.setFont(new Font("Arial", Font.PLAIN, 50));
		add(lb, BorderLayout.PAGE_END);
		play();
	}

	public void play() {
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				int i = 0;
				while (i < 20) {
					g2.setColor(Color.RED);
					g2.fillOval((int)(Math.random()*1000), 50, 50, 50);
					Thread.sleep(1000);
					repaint();
					i++;
					publish(i);
				}
				return null;
			}
			
			@Override
			protected void process(List<Integer> chunks) {
				super.process(chunks);
				lb.setText(String.valueOf(chunks.get(chunks.size() - 1)));
			}
		};
		worker.execute();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g2.drawImage(image, 0, 0, this);
		g.drawImage(image, 0, 0, this);
	}

	public static void main(String[] args) {
		new Window();
	}
}