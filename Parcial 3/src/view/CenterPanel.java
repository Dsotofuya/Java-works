package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class CenterPanel extends JPanel {
	private static final long serialVersionUID = -1210966928811455084L;

	private static final String BACKGROUND = "#d6754f";
	
	private JLabel tittle;
	private CenterSouthPanel centerSouth;
	private JPanelxD principalImage;
	private BufferedImage image;
	private int stickersN;
	private Random random;
	private ArrayList<BufferedImage> stickers;
	
	public CenterPanel(ActionListener control) {
		stickers = new ArrayList<BufferedImage>();
		random = new Random();
		initStickers();
		setPreferredSize(new Dimension(350, 400));
		setBackground(Color.decode(BACKGROUND));
		tittle = new JLabel("Actual Image", SwingConstants.CENTER);
		tittle.setBorder(BorderFactory.createLineBorder(Color.black));
		tittle.setFont(new Font("Arial", Font.BOLD, 20));
		tittle.setPreferredSize(new Dimension(400, 30));
		add(tittle);
		principalImage = new JPanelxD(stickers);
		principalImage.setBorder(BorderFactory.createLineBorder(Color.black));
		principalImage.setPreferredSize(new Dimension(300, 200));
		add(principalImage);
		centerSouth = new CenterSouthPanel(control);
		JScrollPane pane = new JScrollPane(centerSouth);
		pane.setPreferredSize(new Dimension(350, 250));
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(pane);
	}
	
	public void setImagePrincipal(BufferedImage image, int stickers) {
		this.image = image;
		this.stickersN = stickers;
		repaint();
		revalidate();
	}
	
	public void initStickers(){
		try {
			stickers.add(ImageIO.read(new File("src/stickers/1.png")));
			stickers.add(ImageIO.read(new File("src/stickers/2.png")));
			stickers.add(ImageIO.read(new File("src/stickers/0.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 65, 40, principalImage);
		for (int i = 1; i < stickersN; i++) {
			g.drawImage(stickers.get(random.nextInt(3)), random.nextInt(10), random.nextInt(10), principalImage);
		}
	}
}
