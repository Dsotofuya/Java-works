package view.partition.memory;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TableMemory extends JPanel{
	private static final long serialVersionUID = 1L;

	private TableMemoryRowTitle columnNames;
	private ArrayList<TableMemoryRow> rows;
	private JScrollPane scrollPane;
	private JPanel pnlPartitions;
	
	public TableMemory() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pnlPartitions = new JPanel();
		pnlPartitions.setLayout(new BoxLayout(pnlPartitions, BoxLayout.Y_AXIS));
		columnNames = new TableMemoryRowTitle("Particion", "PID", "Tamaño", "Ocupación");
		this.add(columnNames);
		scrollPane = new JScrollPane(pnlPartitions);
		this.add(scrollPane);
		preload();
	}

	public void load(ArrayList<String> partitions) {
		erase();
		for (int i = 0; i < partitions.size(); i++) {
			String[] splitter = partitions.get(i).split(",");
			TableMemoryRow aux = new TableMemoryRow(splitter[0],splitter[1],Integer.parseInt(splitter[2]),Integer.parseInt(splitter[3]));
			rows.add(aux);
			pnlPartitions.add(aux);
		}
		this.updateUI();
		this.repaint();
	}	
	
	public void preload() {
		rows = new ArrayList<TableMemoryRow>();
		for (int i = 0; i < 10; i++) {
			TableMemoryRow aux = new TableMemoryRow("","",0,0);
			rows.add(aux);
			pnlPartitions.add(aux);
		}
	}
	
	public void erase() {
		for (int i = 0; i < rows.size(); i++) {
			pnlPartitions.remove(rows.get(i));;
		}
		while (!rows.isEmpty()) {
			rows.remove(0);
		}
	}
}
