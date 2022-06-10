package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Data.Costants;
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
	JMenuItem exportArchive = new JMenuItem("Export");
	JMenuItem exit = new JMenuItem("Exit");
	
	menu.add(importArchive);
	menu.add(exportArchive);
	menu.add(exit);
	bar.add(menu);
	
	
	setJMenuBar(bar);
	setTitle("Hardware & Asociados");
	setSize(800, 600);
	getContentPane().setBackground(Color.decode(Costants.BACKGROUND));
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	add(buttons, BorderLayout.SOUTH);
	add(table, BorderLayout.CENTER);
	setVisible(true);
	}
}
