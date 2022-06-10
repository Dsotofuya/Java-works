package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import controller.Commands;
import controller.Constants;
import controller.Controller;

public class PanelOptions extends JPanel{
	private static final long serialVersionUID = 1L;
	private JSpinner spnMemorySize, spnPartitionsNumber;
	private JButton btnPartitions, btnStart;
	
	public PanelOptions() {
		this.setLayout(new GridLayout(1, 4));
		spnMemorySize = new JSpinner(new SpinnerNumberModel(256, 16, 256, 16));
		spnMemorySize.setBorder(new TitledBorder(Constants.SPN_MEMORY_NAME));
		spnPartitionsNumber = new JSpinner(new SpinnerNumberModel(2, 2, 8, 1));
		spnPartitionsNumber.setBorder(new TitledBorder(Constants.SPN_PARTITIONS));
		
		btnPartitions = new JButton(Commands.BTN_ADD_PARTITIONS.getName());
		btnPartitions.setActionCommand(Commands.BTN_ADD_PARTITIONS.getCommand());
		btnPartitions.addActionListener(Controller.getInstance());
		
		btnStart = new JButton(Commands.BTN_START.getName());
		btnStart.setActionCommand(Commands.BTN_START.getCommand());
		btnStart.addActionListener(Controller.getInstance());
		
		this.add(spnMemorySize);
		this.add(spnPartitionsNumber);
		this.add(btnPartitions);
		this.add(btnStart);
	}

	public int getPartitions() {
		return Integer.parseInt(spnPartitionsNumber.getValue().toString());
	}

	public int getMemory() {
		return Integer.parseInt(spnMemorySize.getValue().toString());
	}
	
	public void addPartitions() {
		spnMemorySize.setEnabled(false);
		spnPartitionsNumber.setEnabled(false);
		btnPartitions.setEnabled(false);
		repaint();
	}
	
	public void start() {
		btnStart.setEnabled(false);
		repaint();
	}
	
	public void restart() {
		spnMemorySize.setEnabled(true);
		spnPartitionsNumber.setEnabled(true);
		btnPartitions.setEnabled(true);
		btnStart.setEnabled(true);
		repaint();
	}
}
