package View.Dialogs;

import javax.swing.JDialog;

public class discounts_Dialog extends JDialog {
	private static final long serialVersionUID = 3079363191904302358L;
	private Discounts_Panel_Dialog change_Discounts_Panel;
	
	public discounts_Dialog() {
	init();
	setTitle("Cambiar Porcentaje de Descuentos");
	add(change_Discounts_Panel);
	setSize(300, 300);
	pack();
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//	setVisible(true);
	}

	private void init() {
		change_Discounts_Panel = new  Discounts_Panel_Dialog();
	}
	
}
