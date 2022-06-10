package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PanelPartitions extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<JSpinner> spnPartitions;
	private int memory;
	
	public PanelPartitions() {
		
	}
	
	public void setPartitions(int partitions, int memory) {
		this.memory = memory;
		spnPartitions = new ArrayList<JSpinner>();
		this.setLayout(new GridLayout(1, partitions));
		this.setBorder(new EtchedBorder());
		for (int i = 0; i < partitions; i++) {
			JSpinner aux = new JSpinner(new SpinnerNumberModel(memory / partitions,4,512, 1));
			aux.setBorder(new TitledBorder("Particion #" + (i+1)));
			this.add(aux);
			spnPartitions.add(aux);
		}
		repaint();
	}
	
	public int verifyPartitions() {
		int sum = 0;
		for (int i = 0; i < spnPartitions.size(); i++) {
			sum += Integer.parseInt(spnPartitions.get(i).getValue().toString());
		}
		if (sum == memory) {
			return 0;
		}
		if (sum > memory) {
			return 1;
		}
		return 2;
	}
	
	public ArrayList<Integer> getPartitions(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < spnPartitions.size(); i++) {
			list.add(Integer.parseInt(spnPartitions.get(i).getValue().toString()));
		}
		return list;
	}
	
	public void start() {
		for (int i = 0; i < spnPartitions.size(); i++) {
			spnPartitions.get(i).setEnabled(false);
		}
		repaint();
	}
	
	public void restart() {
		for (int i = 0; i < spnPartitions.size(); i++) {
			this.remove(spnPartitions.get(i));
		}
		updateUI();
		repaint();
	}
}
