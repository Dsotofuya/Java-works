package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import view.partition.memory.TableMemory;

import view.partition.process.TableProcess;

public class PanelSimulation extends JPanel {
	private static final long serialVersionUID = 1L;

	private TableProcess tableProcess;
	private TableMemory tableMemory;
	
	public PanelSimulation() {
		this.setLayout(new GridLayout(1, 2));
		tableProcess = new TableProcess();
		tableMemory = new TableMemory();
		
		this.add(tableMemory);
		this.add(tableProcess);
	}
	
	public void loadProcess(ArrayList<String> process) {
		tableProcess.load(process);
	}
	
	public void loadMemory(ArrayList<String> partitions) {
		tableMemory.load(partitions);
	}
}
