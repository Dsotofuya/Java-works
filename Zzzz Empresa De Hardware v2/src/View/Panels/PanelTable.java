package View.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.Costants;
import View.WindowFrame;

public class PanelTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private WindowFrame window;
	private JTable table;
	private String [][] dates = new String[29][20];
	
	public PanelTable(WindowFrame window, ActionListener controller) {
		this.window = window;
		String [] header = {"Id", "Name",
							"Description","Quantity",
							"Price" };
		setBackground(Color.decode(Costants.BACKGROUND));
		DefaultTableModel defaultTableModel = new DefaultTableModel(dates, header);
		table = new JTable(defaultTableModel);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(700, 475));
		add(scroll);
	
	
//	Object[] newRow={"Pepe", "Grillo",
//			 "Tenis", new Integer(5), new Boolean(false), "Pera"};  Añaden una fila extra
//			 defaultTableModel.addRow(newRow);
	}	
}