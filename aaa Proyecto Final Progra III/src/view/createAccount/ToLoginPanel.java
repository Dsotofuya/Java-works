package view.createAccount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Events;

public class ToLoginPanel extends JPanel {
	private static final long serialVersionUID = -2735866766433765429L;

	private static final String _00AC94 = "#00AC94";
	private static final String HAVE_ACCOUNT = "Have Account ? ";
	private static final String EFF0F1 = "#EFF0F1";
	private GridBagConstraints gbc;
	private JLabel haveAccountlbl;
	private JButton loginbtn;
	
	public ToLoginPanel(ActionListener control) {
		setBackground(Color.decode(EFF0F1));
		setPreferredSize(new Dimension(400, 300));
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridy = 0;
		gbc.gridx = 2;
		gbc.weighty =0;
		gbc.gridwidth = 1;
		haveAccountlbl = new JLabel(HAVE_ACCOUNT);
		haveAccountlbl.setFont(new Font("Arial", 4 , 28));
		haveAccountlbl.setHorizontalAlignment(JLabel.CENTER);;
		add(haveAccountlbl, gbc);
		gbc.gridy = 2;
		loginbtn = new JButton();
		loginbtn.setForeground(Color.decode(_00AC94));
		loginbtn.setBackground(Color.decode(EFF0F1));
		loginbtn.setBorder(BorderFactory.createEmptyBorder());
		loginbtn.setText("login");
		loginbtn.setActionCommand(Events.TOLOGIN.toString());
		loginbtn.addActionListener(control);
		loginbtn.setFocusable(false);
		add(loginbtn, gbc);
		gbc.gridy = 3;
		gbc.weighty = 50;
		add(new JLabel(), gbc);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 3; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		} 
		for (int i = 0; i < 10; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}
