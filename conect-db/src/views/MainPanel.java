package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel defaultTableModel;
	private JTable jTable;
	
	public MainPanel() {		
	defaultTableModel = new DefaultTableModel();
		
	jTable = new JTable(defaultTableModel);
	add(new JScrollPane(jTable));
	repaint();
	revalidate();
	}
	
	public JTable getjTable() {
		return jTable;
	}
	
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
}
