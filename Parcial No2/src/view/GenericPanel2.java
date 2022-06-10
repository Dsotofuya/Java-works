package view;

import java.awt.Color;

import javax.swing.JPanel;


public class GenericPanel2 extends JPanel {
	private static final long serialVersionUID = -1210966928811455084L;

	private static final String BACKGROUND = "#FFF5B3";

	public GenericPanel2() {
		setBackground(Color.decode(BACKGROUND));
	}

//	public void fill(ArrayList<Song> songList) throws MalformedURLException {
//		setPreferredSize(new Dimension(400, songList.size() * 28));
//		for (Song song : songList) {
//			URLConnection con;
////			try {
////				con = new URL(song.getUrlImage())
////						.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080)));
////				BufferedImage image = ImageIO.read(con.getInputStream());
//				JLabel card = new JLabel(song.getName(),
//						new ImageIcon(new ImageIcon(/*image*/new URL(song.getUrlImage())).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)),
//						SwingConstants.LEADING);
//				card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//				card.setPreferredSize(new Dimension(200, 50));
//				add(card);
//				repaint();
//				revalidate();
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
//		}
//	}
}
