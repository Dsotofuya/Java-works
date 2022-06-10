package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.Product;

public class PanelProducts extends JPanel{

	private static final long serialVersionUID = 1L;

	public void refreshProducts(ArrayList<Product> products, ActionListener presenter) {
		setLayout(new GridLayout(products.size() / 3, 3, 10 , 10));
		for (Product product : products) {
			add(new ProductCard(product, presenter));
		}
		setBackground(Color.WHITE);
		revalidate();
	}
}