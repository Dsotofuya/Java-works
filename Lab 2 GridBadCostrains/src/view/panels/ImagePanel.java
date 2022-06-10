package view.panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private static final long serialVersionUID = -2082413744719338880L;
	
	private JLabel imageLbl;
	
	public ImagePanel() {
	
		imageLbl = new JLabel(new ImageIcon("src/zData/titulo.png"));
		add(imageLbl);
	}
}
