package View.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Ciudad;
import View.WindowFrame;

public class PanelTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private WindowFrame window;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	
	public PanelTable(WindowFrame window, ActionListener controller) {
		this.window = window;
		setBackground(Color.red);
		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(new Object[] {"Nombre",
												"Latitud",
												"Longitud",
												"Temperatura",
												"Poblacion" });
		table = new JTable(defaultTableModel);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(700, 475));
		add(scroll);
	}	
	
	public void fillTable(ArrayList<Ciudad> listaCiudades) {
		defaultTableModel.setRowCount(0);
		for (Ciudad ciudad : listaCiudades) {
			defaultTableModel.addRow(new Object[] {ciudad.getNombre(), ciudad.getLatitud(), ciudad.getLongitud(), ciudad.getTemperatura(), ciudad.getPoblacion()});
		}
		repaint();
	}

}