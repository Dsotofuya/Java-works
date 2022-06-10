package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ContenPanel extends JPanel {
	private static final long serialVersionUID = -1488521050913935699L;

	private static final String BACKGROUND_COLOR = "#F9A828";
	private static final String BUTTON_COLOR = "#07617D";
	private static final String FONT_COLOR = "#ECECEB";
	private static final String LBL_COLOR = "#2E383F";
	
	private JLabel load;
	private JButton process;
	
	public ContenPanel(JComponent component, String btnText, ActionListener control,
			String comand, String lblText) {
		setPreferredSize(new Dimension(425, 700));
		setBackground(Color.decode(BACKGROUND_COLOR));
		load = new JLabel(lblText, SwingConstants.CENTER);
		load.setForeground(Color.decode(LBL_COLOR));
		load.setBorder(BorderFactory.createLineBorder(Color.decode(LBL_COLOR)));
		load.setPreferredSize(new Dimension(350, 250));
		add(load);
		
		process = new JButton(btnText);
		process.setBackground(Color.decode(BUTTON_COLOR));
		process.setFocusable(false);
		process.setForeground(Color.decode(FONT_COLOR));
		process.addActionListener(control);
		process.setActionCommand(comand);
		add(process);
		
		add(component);
	}
}