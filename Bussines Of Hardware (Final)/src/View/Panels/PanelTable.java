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

import Data.Costants;
import Model.Hardware;
import View.WindowFrame;

public class PanelTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private WindowFrame window;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	
	public PanelTable(WindowFrame window, ActionListener controller) {
		this.window = window;
		setBackground(Color.decode(Costants.BACKGROUND));
		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(new Object[] {window.getLanguajes().getProperty("Id"),
												window.getLanguajes().getProperty("Name"),
												window.getLanguajes().getProperty("Description"),
												window.getLanguajes().getProperty("Quantity"),
												window.getLanguajes().getProperty("Price") });
		table = new JTable(defaultTableModel);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(700, 475));
		add(scroll);
	}	
	
	public void fillTable(ArrayList<Hardware> hardwareList) {
		defaultTableModel.setRowCount(0);
		for (Hardware hardware : hardwareList) {
			defaultTableModel.addRow(new Object[] {hardware.getIdVar(), hardware.getName(), hardware.getDescription(), hardware.getQuantity(), hardware.getPrice()});
		}
		repaint();
	}
	
	public void fillTableDelete(ArrayList<Hardware> hardwareList) {
		defaultTableModel.setRowCount(0);
		for (Hardware hardware : hardwareList) {
			defaultTableModel.removeRow(hardware.getIdVar());
		}
		repaint();
	}
}