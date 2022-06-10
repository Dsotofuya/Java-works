package view.partition.process;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TableProcess extends JPanel {
	private static final long serialVersionUID = 1L;

	private ArrayList<TableProcessRow> rows;
	private JScrollPane scrollPane;
	private JPanel pnl;

	public TableProcess() {
		rows = new ArrayList<TableProcessRow>();
		this.setLayout(new FlowLayout());
		pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(pnl);

		this.add(scrollPane);
		preload();
	}

	public void load(ArrayList<String> process) {
		erase();
		for (int i = 0; i < process.size(); i++) {
			String[] aux = process.get(i).split(",");
			if (Integer.parseInt(aux[1]) < 0) {
				rows.add(new TableProcessRow(" " + (i + 1), aux[0], "0", aux[2], aux[3]));
			} else {
				rows.add(new TableProcessRow(" " + (i + 1), aux[0], aux[1], aux[2], aux[3]));
			}
			pnl.add(rows.get(i));
			updateUI();
			repaint();
		}
	}

	public void preload() {
		pnl.add(new TableProcessRow(" #", "PID", "Tamaño", "Estado", "Realizado"));
		rows = new ArrayList<TableProcessRow>();
		for (int i = 0; i < 10; i++) {
			TableProcessRow aux = new TableProcessRow("" + i, " ", " ", " ", " ");
			rows.add(aux);
			pnl.add(aux);
		}
		repaint();
	}

	public void erase() {
		for (int i = 0; i < rows.size(); i++) {
			pnl.remove(rows.get(i));
			;
		}
		while (!rows.isEmpty()) {
			rows.remove(0);
		}
	}
}
