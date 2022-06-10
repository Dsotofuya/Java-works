package view.center;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftPanel extends JPanel{
	private static final long serialVersionUID = 8564305347290886616L;
	
	private JLabel gameImg;

	public LeftPanel() throws MalformedURLException {
		gameImg = new JLabel();
		gameImg.setBackground(Color.red);
		gameImg.setPreferredSize(new Dimension(460, 215));
		add(gameImg, BorderLayout.CENTER);
	}
	
	public void loadImage(String link) throws MalformedURLException {
		URL source = new URL(link);
		ImageIcon img = new ImageIcon(source);
		gameImg.setIcon(img);
		revalidate();
		repaint();
	}
}
