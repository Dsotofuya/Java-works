package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Control;
import costants.Costants;

public class traduccionPanel extends JPanel {
	
	private static final long serialVersionUID = -4712600291170183534L;
	private JLabel palabra_lbl;
	private JLabel traduccion_lbl;
	private JTextField palabra_txt;
	private JLabel traduccion2_lbl;
	private JButton ingles_btn;
	private JButton frances_btn;
	
	public traduccionPanel(Control control) {
	setLayout(new GridLayout(2,3));
	palabra_lbl = new JLabel("Palabra:");
	add(palabra_lbl);
	palabra_txt = new JTextField();
	add(palabra_txt);
	ingles_btn = new JButton("En ingles");
	ingles_btn.setActionCommand(Costants.TRASLATE_ENGLISH);
	ingles_btn.addActionListener(control);
	add(ingles_btn);
	traduccion_lbl = new JLabel("Traduccion: ");
	add(traduccion_lbl);
	traduccion2_lbl = new JLabel("");
	add(traduccion2_lbl);
	frances_btn = new JButton("En Frances");
	frances_btn.setActionCommand(Costants.TRASLATE_FRENCH);
	frances_btn.addActionListener(control);
	add(frances_btn);
	}
	
	public String getWordText() {
		return palabra_txt.getText();
	}
	
	public void setValueText(String value){
		traduccion2_lbl.setForeground(Color.blue);
		traduccion2_lbl.setText(value);
	}
}
