package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PeanutPunto2 extends JFrame {
	private static final long serialVersionUID = -6644915693652104869L;

	private static final String ICON_PATH = "src/data/icon.png";
	private static final String PARCIAL = "Parcial 2";

	private GenericPanelPunto2 genericpanel;

	public PeanutPunto2(ActionListener control) {
		super(PARCIAL);
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		genericpanel = new GenericPanelPunto2(control);
		add(genericpanel, BorderLayout.CENTER);
		setVisible(true);
	}

	public GenericPanelPunto2 getGenericPanel2() {
		return genericpanel;
	}
	
	public static void main(String[] args) {
		new PeanutPunto2(null);
	}
}
