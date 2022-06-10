package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import model.stack.StackService;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = -7823877324533106290L;

	private ArrayList<BufferedImage> stickers;
	private StackService imageStack;
	private BufferedImage image;
	private Random random;
	private boolean xd;

	public ImagePanel(ArrayList<BufferedImage> stickers) {
		this.stickers = stickers;
		xd = false;
		random = new Random();
		imageStack = new StackService();
		imageStack.add(image);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (xd) {
			BufferedImage auxImage = null;
//			g.drawImage(image, 0, 0, this);
			for (int i = 0; i < random.nextInt(5); i++) {
//				g.drawImage(stickers.get(random.nextInt(4)), random.nextInt(250), random.nextInt(150), this);
				auxImage = paintImages(stickers.get(random.nextInt(4)), random.nextInt(250), random.nextInt(150));
//				try {
//					BufferedImage captura = new Robot().createScreenCapture(new Rectangle(getWidth(), getHeight()));
//					imageStack.add(captura);
//				} catch (HeadlessException | AWTException e) {
//					e.printStackTrace();
//			}
			}
			g.drawImage(auxImage, 0, 0, null);
			
		}
	}

	public BufferedImage paintImages(BufferedImage image, int x, int y) {
		BufferedImage bimage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bimage.createGraphics();
		g2d.drawImage(image, x, y, null);
		g2d.dispose();
		return bimage;
	}

	public StackService getImageStack() {
		return imageStack;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void canAddStickers(Boolean xd) {
		this.xd = xd;
	}
}
