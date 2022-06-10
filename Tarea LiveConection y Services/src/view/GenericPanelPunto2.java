package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Events;

public class GenericPanelPunto2 extends JPanel {
	private static final long serialVersionUID = -2708564640659570565L;

	private static final String BACKGROUND = "#FFF5B3";
	private static final String BUTTON_BACKGROUND = "#A699FF";
	private static final String BUTTON_TEXT = "Registrar";

	private JTextField name, path, number;
	private JButton btn;
	private JLabel text;

	public GenericPanelPunto2(ActionListener control) {
		setBackground(Color.decode(BACKGROUND));
		name = new JTextField("Nombre");
		name.setPreferredSize(new Dimension(200, 30));
		add(name);
		path = new JTextField("Foto (Solo png)");
		path.setPreferredSize(new Dimension(400, 30));
		add(path);
		number = new JTextField("numero");
		number.setPreferredSize(new Dimension(400, 30));
		add(number);
		btn = new JButton(BUTTON_TEXT);
		btn.addActionListener(control);
		btn.setBackground(Color.decode(BUTTON_BACKGROUND));
		btn.setActionCommand(Events.REGISTER.toString());
		add(btn);
		text = new JLabel("Esperando...");
		text.setFont(new Font("Arial", Font.BOLD, 40));
		text.setPreferredSize(new Dimension(450, 50));
		add(text);
	}

	public String getNameText() {
		return name.getText();
	}

	public String getPhotoText() {
		return path.getText();
	}

	public String getNumberText() {
		return number.getText();
	}

	public void setTextLabel(String txt) {
		text.setText(txt);
	}
}
