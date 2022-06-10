package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Events;

public class ScorePanel extends JPanel {
	private static final long serialVersionUID = -8261738831460131176L;
	private JTable scoreTable;
	private JButton menu;
	private DefaultTableModel defaultTable;
	
	public ScorePanel(ResourceBundle bundle, ActionListener control) {
		setBackground(Color.decode("#12702c"));
		defaultTable = new DefaultTableModel();
		defaultTable.setColumnIdentifiers(new Object[] {bundle.getString("userName"), bundle.getString("score")});
		scoreTable = new JTable(defaultTable);
		scoreTable.setFocusable(false);
		JScrollPane scroll = new JScrollPane(scoreTable);
		scroll.setPreferredSize(new Dimension(500, 500));
		add(scroll);
		menu = new JButton(bundle.getString("menu"));
		menu.setPreferredSize(new Dimension(300, 30));
		menu.setActionCommand(Events.MENU.toString());
		menu.addActionListener(control);
		menu.setFocusable(false);
		menu.setBackground(Color.decode("#32a852"));
		menu.setForeground(Color.WHITE);
		add(menu);
		
	}
	
	public void fillTable(ConcurrentHashMap<String, Integer> scores) {
		defaultTable.setRowCount(0);
		for (String user: scores.keySet()) {
			defaultTable.addRow(new Object[] {user, scores.get(user)});
		}
		repaint();
	}

}
