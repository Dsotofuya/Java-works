package view.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class panelExtension extends JPanel {
	private static final long serialVersionUID = 3152993635221509696L;
	
	private JButton opcion1;
	private JButton opcion2;
	
	public panelExtension() {
		setLayout(new GridLayout(1,2));
		TitledBorder tittle = BorderFactory.createTitledBorder("Opciones");
		setBorder(tittle);
		opcion1 = new JButton("Opción 1");
		add(opcion1);
		opcion2 = new JButton("Opcion 2");
		add(opcion2);
	}
}
