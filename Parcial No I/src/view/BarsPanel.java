package view;

	import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

	public class BarsPanel extends JPanel {
		private static final long serialVersionUID = -9218208369265382035L;

		private int percentOne;
		private int percentTwo;
		
		public BarsPanel(int percentFolderOne, int percentFolderTwo) {
			this.percentOne = percentFolderOne;
			this.percentTwo = percentFolderTwo;
			setPreferredSize(new Dimension(400, 300));
			setBorder(BorderFactory.createLineBorder(Color.darkGray));
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.red);
			g.fillRect(10, 10, percentOne, 100);
			g.setColor(Color.black);
			g.drawRect(10, 10, 360, 100);
			g.setColor(Color.blue);
			g.fillRect(10, 120, percentTwo, 100);
			g.setColor(Color.black);
			g.drawRect(10, 120, 360, 100);
		}

		
		public void update(int percentFolderOne, int percentFolderTwo) {
			this.percentOne = percentFolderOne;
			this.percentTwo = percentFolderTwo;
			repaint();
		}
}
