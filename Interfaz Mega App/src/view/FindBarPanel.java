package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FindBarPanel extends JPanel {
	private static final long serialVersionUID = 8358463779315903403L;

	private JLabel findTxtF;
	private JButton findBtn;
	private JButton optionsBtn;
	private JButton menuBtn;
	private JButton organizeBtn;
	private GridBagConstraints gbc;

	public FindBarPanel() {
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		menuBtn = new JButton("Menu");
		menuBtn.setFocusable(false);
		menuBtn.setBorder(BorderFactory.createEmptyBorder());
		menuBtn.setBackground(Color.decode("#FAFAFA"));
		add(menuBtn, gbc);
		findTxtF = new JLabel("MI NUBE");
		findTxtF.setFocusable(false);
		findTxtF.setBorder(BorderFactory.createEmptyBorder());
		findTxtF.setFont(new Font("Arial",1, 14));
		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;
		gbc.weightx = 8;
		gbc.weighty = 2;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(findTxtF, gbc);
		findBtn = new JButton(new ImageIcon("src/zData/blackLenIcon.png"));
		findBtn.setFocusable(false);
		findBtn.setBorder(BorderFactory.createEmptyBorder());
		findBtn.setBorderPainted(false);
		findBtn.setBackground(Color.decode("#FAFAFA"));
		gbc.gridx = 8;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridwidth = 1;
		gbc.weightx = .2;
		add(findBtn, gbc);
		organizeBtn = new JButton(new ImageIcon("src/zData/gridIcon.png"));
		organizeBtn.setFocusable(false);
		organizeBtn.setBorder(BorderFactory.createEmptyBorder());
		organizeBtn.setBackground(Color.decode("#FAFAFA"));
		gbc.gridx = 8;
		gbc.gridx = 9;
		add(organizeBtn, gbc);
		optionsBtn = new JButton(new ImageIcon("src/zData/optionIcon.png"));
		optionsBtn.setBackground(Color.decode("#FAFAFA"));
		optionsBtn.setFocusable(false);
		optionsBtn.setBorder(BorderFactory.createEmptyBorder());
		gbc.gridx = 8;
		gbc.gridx = 10;
		add(optionsBtn, gbc);
		setBackground(Color.decode("#FAFAFA"));
	}
}
