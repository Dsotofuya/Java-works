package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	private ImagePanel principalImage;
	private ArrayList<BufferedImage> stickers;
	
	public CenterPanel(ActionListener control) {
		stickers = new ArrayList<BufferedImage>();
		initStickers();
		setPreferredSize(new Dimension(350, 400));
		setBackground(Color.decode(BACKGROUND));
		tittle = new JLabel("Actual Image", SwingConstants.CENTER);
		tittle.setBorder(BorderFactory.createLineBorder(Color.black));
		tittle.setFont(new Font("Arial", Font.BOLD, 20));
		tittle.setPreferredSize(new Dimension(400, 30));
		add(tittle);
		principalImage = new ImagePanel(stickers);
		principalImage.setBorder(BorderFactory.createLineBorder(Color.black));
		principalImage.setPreferredSize(new Dimension(300, 200));
		add(principalImage);
		centerSouth = new CenterSouthPanel(control);
		JScrollPane pane = new JScrollPane(centerSouth);
		pane.setPreferredSize(new Dimension(350, 260));
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		add(pane);
	}
	
	public void setImagePrincipal(BufferedImage image, Boolean xd) {
		principalImage.setImage(image);
		principalImage.canAddStickers(xd);
		repaint();
		revalidate();
	}
	
	public void initStickers(){
		try {
			stickers.add(ImageIO.read(new File("src/stickers/1.png")));
			stickers.add(ImageIO.read(new File("src/stickers/2.png")));
			stickers.add(ImageIO.read(new File("src/stickers/0.png")));
			stickers.add(ImageIO.read(new File("src/stickers/3.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CenterSouthPanel getCenterSouth() {
		return centerSouth;
	}
	
	public ImagePanel getPrincipalImage() {
		return principalImage;
	}
}
