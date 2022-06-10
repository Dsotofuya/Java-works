package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Control.Control;
import Costants.Costants;

public class tax_Panel extends JPanel {

	private static final long serialVersionUID = -137094673687581362L;
	private JLabel total_Value_lbl;
	private JLabel total_Value_number_lbl;
	private JLabel empty_lbl;
	private JLabel empty2_lbl;
	private JButton calculate_btn;
	private JButton clean_btn;
	private Control controller;
	
	 public tax_Panel(Control controller) {
		 super();
		 this.controller = controller;
		 TitledBorder title = BorderFactory.createTitledBorder("Calcular impuesto");
		 title.setTitleColor(Color.blue);
		 setBorder(title);
		 setLayout(new GridLayout(2,3));
		 init();
		 add(total_Value_lbl);
		 add(total_Value_number_lbl);
		 add(calculate_btn);
		 add(empty_lbl);
		 add(empty2_lbl);
		 add(clean_btn);
	}
	
	private void init() {
		total_Value_lbl = new JLabel("Total a pagar");
		total_Value_number_lbl = new JLabel();
		calculate_btn = new JButton("Calcular");
		calculate_btn.setActionCommand(Costants.CALCULATE);
		calculate_btn.addActionListener(controller);
		empty_lbl = new JLabel();
		empty2_lbl = new JLabel();
		clean_btn = new JButton("Limpiar");
		clean_btn.setActionCommand(Costants.CLEAN);
		clean_btn.addActionListener(controller);
	}
	
	public void clean() {
		total_Value_number_lbl.setText("");
	}
	
	public void setValueText(String value){
		total_Value_number_lbl.setForeground(Color.blue);
		total_Value_number_lbl.setText(value);
	}
}
