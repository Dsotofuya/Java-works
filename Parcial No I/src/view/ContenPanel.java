package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import control.Events;

public class ContenPanel extends JPanel {
	private static final long serialVersionUID = -1488521050913935699L;

	private static final String BACKGROUND_COLOR = "#F9A828";
	private static final String BUTTON_COLOR = "#07617D";
	private static final String FONT_COLOR = "#ECECEB";
	
	private JButton pause, reanude;
	
	public ContenPanel(JComponent component, ActionListener control) {
		setPreferredSize(new Dimension(425, 700));
		setBackground(Color.decode(BACKGROUND_COLOR));
		pause = new JButton("Pausa");
		pause.setBackground(Color.decode(BUTTON_COLOR));
		pause.setFocusable(false);
		pause.setForeground(Color.decode(FONT_COLOR));
		pause.addActionListener(control);
		pause.setActionCommand(Events.PAUSE.toString());
		reanude = new JButton("Reanudar");
		reanude.setBackground(Color.decode(BUTTON_COLOR));
		reanude.setFocusable(false);
		reanude.setForeground(Color.decode(FONT_COLOR));
		reanude.addActionListener(control);
		reanude.setActionCommand(Events.REANUDE.toString());
		add(pause);
		add(reanude);
		add(component);
	}
}