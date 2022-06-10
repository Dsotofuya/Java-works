package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Song;

public class CardsPanel extends JPanel {
	private static final long serialVersionUID = -1210966928811455084L;

	private static final String BACKGROUND = "#FFF5B3";

	public CardsPanel() {
		setBackground(Color.decode(BACKGROUND));
	}

	public void fill(ArrayList<Song> songList) throws MalformedURLException {
		setPreferredSize(new Dimension(400, songList.size() * 28));
		for (Song song : songList) {
			URLConnection con;
//			try {
//				con = new URL(song.getUrlImage())
//						.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080)));
//				BufferedImage image = ImageIO.read(con.getInputStream());
				JLabel card = new JLabel(song.getName(),
						new ImageIcon(new ImageIcon(/*image*/new URL(song.getUrlImage())).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)),
						SwingConstants.LEADING);
				card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				card.setPreferredSize(new Dimension(200, 50));
				add(card);
				repaint();
				revalidate();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}
}
