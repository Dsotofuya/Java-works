package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entity.Publicacion;

public class Card extends JDialog{

	private static final long serialVersionUID = 1L;

	public Card(Publicacion publicacion , ActionListener listener) throws IOException {
		
		this.getContentPane().setBackground( Color.WHITE );
		setLocationRelativeTo(null);
		setTitle("Objeto");
		setIconImage(new ImageIcon(getClass().getResource("/img/icono.JPG")).getImage());
		setLayout(new FlowLayout());
		File imgFile = new File(publicacion.getImg());
		BufferedImage img = ImageIO.read(imgFile);
		JLabel lblImg = new JLabel();
		int sizeX =img.getHeight()/2;
		int sizeY = img.getWidth()/2;
		if (sizeY > 500 || sizeX >500) {
			sizeX = (int) (sizeX/2.2);
			sizeY = (int) (sizeY/2.2);
		}
		img = resize(img, sizeX,sizeY);
		ImageIcon imageIcon = new ImageIcon(img);
		lblImg.setIcon(imageIcon);
		lblImg.setBorder(new EmptyBorder(0, 10, 0, 0));
		add(lblImg);
		
		setSize(new Dimension(img.getWidth()+200, img.getHeight() + 100));
		panelInfo(publicacion , listener);
		setVisible(true);
		
	}
	
	private void panelInfo(Publicacion pu , ActionListener listener) {
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.WHITE );
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		JLabel lblTitle = new JLabel(pu.getTitle());
		lblTitle.setFont(new Font("Roboto", Font.PLAIN, 20));
		panelInfo.add(lblTitle);
		
		JLabel lblName = new JLabel(pu.getDescription());
		lblName.setFont(new Font("Roboto", Font.PLAIN, 20));
		panelInfo.add(lblName);
		
		JLabel lblPhone = new JLabel(pu.getPhone());
		lblPhone.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblPhone.setBorder(new EmptyBorder(0, 0, 20, 0));
		panelInfo.add(lblPhone);
		
		JButton btnContact = new JButton("Contacto");
		btnContact.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnContact.setBackground(Color.WHITE);
		btnContact.setFocusable(false);
		btnContact.setName(String.valueOf(pu.getId()));
		btnContact.setActionCommand(control.Action.CONTACT.toString());
		btnContact.addActionListener(listener);
		panelInfo.add(btnContact);
		add(panelInfo);
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
