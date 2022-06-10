package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Control.Events;
import Data.Costants;
import Data.Properties;
import View.Panels.PanelButtons;
import View.Panels.PanelTable;

public class WindowFrame extends JFrame{
	
	private PanelButtons buttons;
	private PanelTable table;
	private Properties languajes;
	
	public WindowFrame(ActionListener controller, String languaje) {
	this.languajes = new Properties(languaje);
	buttons = new PanelButtons(this, controller);
	table = new PanelTable(this, controller);
		
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu();
	menu.setText(languajes.getProperty("Archive"));
	
	JMenuItem addHardware = new JMenuItem(languajes.getProperty("Add"));
	addHardware.addActionListener(controller);
	addHardware.setActionCommand(Events.SHOW_DIALOG_ADD.toString());
	
	JMenuItem deleteHardware = new JMenuItem(languajes.getProperty("Delete"));
	deleteHardware.addActionListener(controller);
	deleteHardware.setActionCommand(Events.SHOW_DELETE_DIALOG.toString());
	
	JMenuItem importArchive = new JMenuItem(languajes.getProperty("Import"));
	importArchive.addActionListener(controller);
	importArchive.setActionCommand(Events.IMPORT.toString());
	
	JMenuItem exportArchive = new JMenuItem(languajes.getProperty("Export"));
	exportArchive.addActionListener(controller);
	exportArchive.setActionCommand(Events.EXPORT.toString());
	
	JMenuItem exit = new JMenuItem(languajes.getProperty("Exit"));
	exit.addActionListener(controller);
	exit.setActionCommand(Events.EXIT.toString());
	
	JMenu lenguajeChange = new JMenu(languajes.getProperty("Languaje"));
	
	JMenuItem spanish = new JMenuItem(languajes.getProperty("Espa�ol"));
	spanish.addActionListener(controller);
	spanish.setActionCommand(Events.ESPANIOL.toString());
	
	JMenuItem english = new JMenuItem(languajes.getProperty("Ingles"));
	english.addActionListener(controller);
	english.setActionCommand(Events.INGLES.toString());
	
	JMenuItem frances = new JMenuItem(languajes.getProperty("Frances"));
	frances.addActionListener(controller);
	frances.setActionCommand(Events.FRANCES.toString());
	
	JMenuItem portugues = new JMenuItem(languajes.getProperty("Portugues"));
	portugues.addActionListener(controller);
	portugues.setActionCommand(Events.PORTUGUES.toString());
	
	JMenuItem chino = new JMenuItem(languajes.getProperty("Chino"));
	chino.addActionListener(controller);
	chino.setActionCommand(Events.CHINO.toString());
	
	
	
	lenguajeChange.add(spanish);
	lenguajeChange.add(english);
	lenguajeChange.add(frances);
	lenguajeChange.add(portugues);
	lenguajeChange.add(chino);
	
	menu.add(addHardware);
	menu.add(deleteHardware);
	menu.add(importArchive);
	menu.add(exportArchive);
	menu.add(exit);
	bar.add(menu);
	bar.add(lenguajeChange);
	
	
	setJMenuBar(bar);
	setTitle(languajes.getProperty("Title"));
	setSize(800, 600);
	getContentPane().setBackground(Color.decode(Costants.BACKGROUND));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	add(buttons, BorderLayout.SOUTH);
	add(table, BorderLayout.CENTER);
	setVisible(true);
	}
	
	public void setTable(PanelTable table) {
		this.table = table;
	}

	public PanelTable getTable() {
		return table;
	}

	public void setLanguajes(String languajes) {
		this.languajes = new Properties(languajes);
	}

	public Properties getLanguajes() {
		return languajes;
	}
	
}
