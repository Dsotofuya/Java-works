package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import models.Product;

public class WindowStore extends JFrame{

	private static final String TEXT_TOTAL = "Total: $";
	public static final String ARIAL = "Arial";
	public static final String COLOR_GREEN = "#339266";
	private static final String TEXT_PRODUCTS = "Products";
	private static final String STORE_NAME = "Store";
	private static final long serialVersionUID = 1L;
	private static final String ICON_PATH = "/img/icon.png";
	private static final String TEXT_CAR = "Car";
	
	private DefaultListModel<Product> modelCar;
	private JLabel lbTotal;
	private PanelProducts panelProducts;

	public WindowStore(ActionListener presenter) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(STORE_NAME);
		setIconImage(new ImageIcon(getClass().getResource(ICON_PATH)).getImage());
		
		getContentPane().setBackground(Color.WHITE);
		
		lbTotal = new JLabel(TEXT_TOTAL, SwingConstants.CENTER);
		lbTotal.setFont(new Font(ARIAL, Font.BOLD, 30));
		lbTotal.setForeground(Color.decode(COLOR_GREEN));
		add(lbTotal, BorderLayout.PAGE_START);
		
		JPanel panelCenter = new JPanel(new GridLayout(1, 2));
		
		panelProducts = new PanelProducts();
		panelProducts.setBorder(BorderFactory.createTitledBorder(TEXT_PRODUCTS));
		panelCenter.add(new JScrollPane(panelProducts));
		
		modelCar = new DefaultListModel<>();
		JList<Product> carList = new JList<>(modelCar);
		carList.setBorder(BorderFactory.createTitledBorder(TEXT_CAR));
		panelCenter.add(new JScrollPane(carList));
		
		add(panelCenter, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void setTotal(double total) {
		lbTotal.setText(TEXT_TOTAL + Double.valueOf(total));
	}
	
	public void initList(ArrayList<Product> products, ActionListener presenter) {
		panelProducts.refreshProducts(products, presenter);
	}
	
	public void initCar(ArrayList<Product> products) {
		modelCar.clear();
		for (Product product : products) {
			modelCar.addElement(product);
		}
	}
}