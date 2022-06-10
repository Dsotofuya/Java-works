package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entity.Publicacion;

public class CardProduct extends JPanel {

	private static final long serialVersionUID = 1L;

	public CardProduct(Publicacion publicacion, ActionListener listener) throws IOException {
	
		setBackground( Color.WHITE );
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		File imgFile = new File(publicacion.getImg());
		BufferedImage img = ImageIO.read(imgFile);
		JLabel lblImg = new JLabel();
		img = resize(img, 200 ,200);
		ImageIcon imageIcon = new ImageIcon(img);
		lblImg.setIcon(imageIcon);
		lblImg.setBorder(new EmptyBorder(0, 10, 0, 0));
		lblImg.setAlignmentX(CENTER_ALIGNMENT);
		add(lblImg);
		
		JLabel lblTitle = new JLabel(publicacion.getTitle());
		lblTitle.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);
		
		JButton btnContact = new JButton("Ver");
		btnContact.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnContact.setBackground(Color.WHITE);
		btnContact.setFocusable(false);
		btnContact.setName(String.valueOf(publicacion.getId()));
		btnContact.setActionCommand(control.Action.VER.toString());
		btnContact.addActionListener(listener);
		btnContact.setAlignmentX(CENTER_ALIGNMENT);
		add(btnContact);
	}


	   private static BufferedImage resize(BufferedImage img, int height, int width) {
	        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = resized.createGraphics();
	        g2d.drawImage(tmp, 0, 0, null);
	        g2d.dispose();
	        return resized;
	    }
}
