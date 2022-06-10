package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import model.entity.Publicacion;

public class PanelProducts extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelProducts(ArrayList< Publicacion > listPublicacion , ActionListener listener) {
		setBackground(Color.WHITE);
	}
	
	public void paintCards(ArrayList< Publicacion > listPublicacion , ActionListener listener) {
		removeAll();
		if (listPublicacion != null) {
			for (int i = 0; i < listPublicacion.size(); i++) {
				try {
					CardProduct c1 = new CardProduct(listPublicacion.get(i), listener);
					add(c1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		repaint();
		revalidate();
	}
	
	public void repaintPanel() {
		repaint();
	}
}
