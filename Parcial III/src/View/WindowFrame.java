package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Control.Events;
import View.Panels.PanelButtons;
import View.Panels.PanelTable;

public class WindowFrame extends JFrame{
	
	private PanelButtons buttons;
	private PanelTable table;
	
	public WindowFrame(ActionListener controller) {
	
	buttons = new PanelButtons(this, controller);
	table = new PanelTable(this, controller);
		
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu();
	menu.setText("Archive");
	
	JMenuItem importArchive = new JMenuItem("Import");
	importArchive.addActionListener(controller);
	importArchive.setActionCommand(Events.IMPORT.toString());
	JMenuItem exportArchive = new JMenuItem("Export");
	exportArchive.addActionListener(controller);
	exportArchive.setActionCommand(Events.EXPORT.toString());
	JMenuItem exit = new JMenuItem("Exit");
	exit.addActionListener(controller);
	exit.setActionCommand(Events.EXIT.toString());
	
	menu.add(importArchive);
	menu.add(exportArchive);
	menu.add(exit);
	bar.add(menu);
	
	
	setJMenuBar(bar);
	setTitle("Parcial III - Ciuadades");
	setSize(800, 600);
	getContentPane().setBackground(Color.GREEN);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	add(buttons, BorderLayout.SOUTH);
	add(table, BorderLayout.CENTER);
	setVisible(true);
	}

	public PanelTable getTable() {
		return table;
	}

	public void setTable(PanelTable table) {
		this.table = table;
	}

}
