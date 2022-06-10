package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class contadorPanel extends JPanel {
	private static final long serialVersionUID = -7929631265012367157L;
	
	private JLabel inglesInfo_lbl;
	private JLabel inglesInfo2_lbl;
	private JLabel francesInfo_lbl;
	private JLabel francesInfo2_lbl;
	
	public contadorPanel() {
	setLayout(new GridLayout(1,4));
	inglesInfo_lbl = new  JLabel("Ingles: ");
	add(inglesInfo_lbl);
	inglesInfo2_lbl = new  JLabel("");
	add(inglesInfo2_lbl);
	francesInfo_lbl = new  JLabel("Frances: ");
	add(francesInfo_lbl);
	francesInfo2_lbl = new  JLabel("");
	add(francesInfo2_lbl);
	}	
	
	public void setInglesInfoText(String value){
		inglesInfo2_lbl.setForeground(Color.blue);
		inglesInfo2_lbl.setText(value);
	}
	public void setFrancesText(String value){
		francesInfo2_lbl.setForeground(Color.blue);
		francesInfo2_lbl.setText(value);
	}
	
}
