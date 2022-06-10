package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants;
import control.Control;

public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = 7156678755549073273L;
	
	private JButton cakeBtn;
	private JButton barsBtn;
	public ButtonsPanel(Control control) {
		cakeBtn = new JButton("Grafico De Pastel");
		cakeBtn.setActionCommand(Constants.CAKE);
		cakeBtn.addActionListener(control);
		add(cakeBtn);
		barsBtn = new JButton("Grafico De Barras");
		barsBtn.setActionCommand(Constants.BARS);
		barsBtn.addActionListener(control);
		add(barsBtn);
	}
}
