package View.Dialogs;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Discounts_Panel_Dialog extends JPanel {
	private static final long serialVersionUID = 5916745933964603239L;
	private JLabel paid_lbl;
	private JLabel public_lbl;
	private JLabel location_lbl;
	private JTextField location_txt;
	private JTextField public_txt;
	private JTextField paid_txt;
	private JButton acept_btn;
	private JButton cancel_btn;
	
	public Discounts_Panel_Dialog() {
		setLayout(new GridLayout(4,2));
		init();	
		add(paid_lbl);
		add(paid_txt);
		add(public_lbl);
		add(public_txt);
		add(location_lbl);
		add(location_txt);
		add(acept_btn);
		add(cancel_btn);
	}
	
	private void init() {
		paid_lbl = new JLabel("Pronto Pago");
		public_lbl = new JLabel("Servicio Publico");
		location_lbl = new JLabel("Matriculado en");
		location_txt = new JTextField();
		public_txt = new JTextField();
		paid_txt = new JTextField();
		acept_btn = new JButton("Aceptar");
		cancel_btn = new JButton("Cancel"); 
	}
}
