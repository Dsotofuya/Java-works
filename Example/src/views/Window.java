package views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private int count = 0;
	private boolean done;
	
	public Window() {
		setSize(500, 500);
		setLocationRelativeTo(null);

		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				for (int i = 0; i < 10; i++) {
					count++;
					Thread.sleep(1000);
					repaint();
				}
				return null;
			}
			
			@Override
			protected void done() {
				done = true;
				repaint();
			}
		};
		worker.execute();
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (done) {
			g.setColor(Color.GREEN);
		}
		g.drawRect(50, 50, 400, 100);
		g.fillRect(50, 50, count * 40, 100);
	}
	
	public static void main(String[] args) {
		new Window();
	}
}