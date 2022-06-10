package View.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.Costants;
import View.FrameHardware;

public class PanelTable extends JPanel {
	
	/**
	 * Mantiene la tabla Jtable con los datos
	 */
	private static final long serialVersionUID = 1L;
	private FrameHardware window;
	private JTable table;
	private String [][] dates = new String[29][20];
	
	
	private String [] header = {"Id", "Nombre", "Descripción", "Cantidad", "Precio" };
	
	public PanelTable(FrameHardware window, ActionListener controller) {
		this.window = window;
		String [] header = {window.getLenguaje().getProperty("Id"), window.getLenguaje().getProperty("Name"),
							window.getLenguaje().getProperty("Description"),window.getLenguaje().getProperty("Quantity"),
							window.getLenguaje().getProperty("Price") };
		setBackground(Color.decode(Costants.BACKGROUND));
		DefaultTableModel defaultTableModel = new DefaultTableModel(dates, header);
		table = new JTable(defaultTableModel);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(700, 475));
		add(scroll);
	
	
	Object[] newRow={"Pepe", "Grillo",
			 "Tenis", new Integer(5), new Boolean(false), "Pera"};
			 defaultTableModel.addRow(newRow);
	}	
}