package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.FixedPartition;
import model.Partition;
import model.Process;
import util.Numbers;
import view.MainWindow;
import view.Messages;

public class Controller implements ActionListener{
	
	private static Controller instance;
	private MainWindow mainWindow;
	private ArrayList<Process> processes;
	ArrayList<String> processString;
	private Messages messages;
	
	private FixedPartition fixedPartition;
	
	private Timer timer;
	private TimerTask task;
	
	
	private Controller() {
		messages = new Messages();
		timer = new Timer();
	}
	
	public void set(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case BTN_START:
			int fixedPartitions = mainWindow.getPanelOptions().getPartitions();
			loadProcess();
			fixedPartition = new FixedPartition(mainWindow.getPanelOptions().getMemory(), fixedPartitions, processes);
			loadPartitions();
			processes = fixedPartition.getProcesses();
			startFixed();
		default:
			break;
		}
		
	}

	private void loadPartitions() {
		ArrayList<String> partitions = new ArrayList<String>();
		for (int i = 0; i < fixedPartition.getPartitions().size(); i++) {
			Partition aux = fixedPartition.getPartitions().get(i);
			System.out.println("CLASS:  Controller -> Contenido de particion = " + aux.toString());
			partitions.add(aux.toString());	
		}
		mainWindow.getPanelSimulation().loadMemory(partitions);
	}

	private void startFixed() {
		task = new TimerTask() {
			
			@Override
			public void run() {
				while (fixedPartition.getProcesses().isEmpty() == false) {
					for (int i = 0; i < fixedPartition.getProcesses().size(); i++) {
						fixedPartition.assing(fixedPartition.getProcesses().get(i));
					}
					loadPartitions();
					updateProcess();
					fixedPartition.free();
					mainWindow.getStadePane().increaste((fixedPartition.getProcessesFinalized().size() * 100) / 20);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				messages.confirmMessage(mainWindow, "Simulacion terminada");
			}
		};
		timer.schedule(task, 3000);
	}

	public static void main(String[] args) {
		Controller.getInstance().set(new MainWindow());;
	}
	
	private void loadProcess() {
		processes = new ArrayList<Process>();
		for (int i = 1; i <= 20; i++) {
			if (i < 10) {
				processes.add(new Process("PRC00" + i, Numbers.generateNumberInt(4, 512)));
			} else {
				processes.add(new Process("PRC0" + i, Numbers.generateNumberInt(4, 512)));
			}
		}
		processString = new ArrayList<String>();
		for (int i = 0; i < processes.size() ; i++) {
			processString.add(processes.get(i).toString());
		}
		mainWindow.getPanelSimulation().loadProcess(processString);
	}
	
	private void updateProcess() {
		processString = new ArrayList<String>();
		for (int i = 0; i < processes.size() ; i++) {
			processString.add(processes.get(i).toString());
		}
		mainWindow.getPanelSimulation().loadProcess(processString);
	}
}
