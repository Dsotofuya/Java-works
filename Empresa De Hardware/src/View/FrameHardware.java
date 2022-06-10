package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import Data.Costants;
import Data.Properties;
import View.Panels.PanelButtons;
import View.Panels.PanelTable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Control.Controller;

public class FrameHardware extends JFrame {

	/**
	 * Frame principal
	 */
	private static final long serialVersionUID = 1L;
	
	private PanelTable table;
	private PanelButtons buttons;
	private Properties lenguaje;
	private Controller controller;
	
	public FrameHardware() {
		init("ESPAÑOL", controller );
		
	}
	
	private void init(String lenguajeSelected, ActionListener controller) {
		lenguaje = new Properties(lenguajeSelected);
		buttons = new PanelButtons(this, controller);
		table = new PanelTable(this, controller);

		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu();
		menu.setText(lenguaje.getProperty("Archive"));
		
		JMenuItem importArchive = new JMenuItem(lenguaje.getProperty("Import"));
		JMenuItem exportArchive = new JMenuItem(lenguaje.getProperty("Export"));
		JMenuItem exit = new JMenuItem(lenguaje.getProperty("Exit"));
		
		menu.add(importArchive);
		menu.add(exportArchive);
		menu.add(exit);
		bar.add(menu);
		
		
		setJMenuBar(bar);
		setTitle(lenguaje.getProperty("Title"));
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

	public Properties getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(Properties lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	public static void main(String[] args) {
		new FrameHardware();
	}
}
