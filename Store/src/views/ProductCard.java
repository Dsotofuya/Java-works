package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.Product;
import presenters.Events;

public class ProductCard extends JPanel{

	private static final int IMG_SIZE = 200;
	private static final long serialVersionUID = 1L;
	private static final String TEXT_ADD_TO_CART = "Add to car";
	private static final String ADD_ICON_PATH = "/img/addIcon.png";
	private static final String IMG_PATH = "/img/product.jpg";

	public ProductCard(Product product, ActionListener presenter) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JLabel lbInfo = new JLabel(product.getName() + " $" + Double.toString(product.getPrice()), SwingConstants.CENTER);
		lbInfo.setFont(new Font(WindowStore.ARIAL, Font.BOLD, 30));
		add(lbInfo, BorderLayout.PAGE_START);
		
		JLabel lbName = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(IMG_PATH)).getImage().getScaledInstance(IMG_SIZE, IMG_SIZE, Image.SCALE_SMOOTH)), SwingConstants.CENTER);
		add(lbName, BorderLayout.CENTER);
		
		JButton btnAddToCar = new JButton(TEXT_ADD_TO_CART);
		btnAddToCar.addActionListener(presenter);
		btnAddToCar.setActionCommand(Events.ADD.toString());
		btnAddToCar.setForeground(Color.WHITE);
		btnAddToCar.setBackground(Color.decode(WindowStore.COLOR_GREEN));
		btnAddToCar.setFont(new Font(WindowStore.ARIAL, Font.PLAIN, 16));
		btnAddToCar.setIcon(new ImageIcon(getClass().getResource(ADD_ICON_PATH)));
		btnAddToCar.setName(Integer.toString(product.getId()));
		add(btnAddToCar, BorderLayout.PAGE_END);
	}
}