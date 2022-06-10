package view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jpane extends JPanel{

	private static final long serialVersionUID = 1L;

	public Jpane() {

		GridSystem grid = new GridSystem(this);
		
		JLabel lblIdiomas = new JLabel();
//		lblIdiomas.setPreferredSize(new Dimension(40, 40));
		
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/idiomas.png"));
		imageIcon.getImage().getScaledInstance(20 , 20, Image.SCALE_SMOOTH);
		
		lblIdiomas.setIcon(imageIcon);
		add(new JButton(), grid.insertComponent(1, 2, 6, 4) );
//		add(lblIdiomas, grid.insertComponent(0, 0, 5, 1));

//
//		JLabel lblRIUptc = new JLabel(new ImageIcon(getClass().getResource("/img/RIUptc.png")));
//		add(lblRIUptc);	
//
//		JLabel lblRevista = new JLabel(new ImageIcon(getClass().getResource("/img/revistas.png")));
//		add(lblRevista);	
//
//		JLabel lblMemorias = new JLabel(new ImageIcon(getClass().getResource("/img/memorias.png")));
//		add(lblMemorias);	
//
//		JLabel lblRadio = new JLabel(new ImageIcon(getClass().getResource("/img/radio.png")));
//		add(lblRadio);	
//
//		JLabel lblUnisalud = new JLabel(new ImageIcon(getClass().getResource("/img/unisalud.png")));
//		add(lblUnisalud);	
//
//		JLabel lblSIG = new JLabel(new ImageIcon(getClass().getResource("/img/sig.png")));
//		add(lblSIG);	
//
//		JLabel lblsgs = new JLabel(new ImageIcon(getClass().getResource("/img/sgs.png")));
//		add(lblsgs);	
//
	
	
	}
}
