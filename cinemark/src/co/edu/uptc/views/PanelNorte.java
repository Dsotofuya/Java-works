package co.edu.uptc.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


	public class PanelNorte extends JPanel {

		private JFMainWindow ventana;
		private JLabel label;
		private JButton button;

		public PanelNorte(JFMainWindow ventana) {
			this.ventana = ventana;
			this.setLayout(new GridLayout(1,2));
			this.setVisible(true);
			this.initComponets();

		}

		public void initComponets() {
			ImageIcon image = new ImageIcon(getClass().getResource("/co/edu/uptc/img/silla.png"));
			label = new JLabel();
			label.setIcon(image);
			label.setBackground(Color.red);
			add(label);
		}

}
