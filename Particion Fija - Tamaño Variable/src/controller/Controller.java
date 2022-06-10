package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.VariablePartition;
import model.Partition;
import model.Process;
import util.Numbers;
import view.MainWindow;
import view.Messages;

public class Controller implements ActionListener{
	
	private static Controller instance;
	private MainWindow mainWindow;
	private ArrayList<Process> processes;
	private ArrayList<String> processString;
	private Messages messages;
	
	private VariablePartition variablePartition;
	
	private Timer timer;
	private TimerTask task;
	
	private int partitions;
	private int memory;
	
	
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
		case BTN_ADD_PARTITIONS:
			partitions = mainWindow.getPanelOptions().getPartitions();
			memory = mainWindow.getPanelOptions().getMemory();
			mainWindow.getPanelPartitions().setPartitions(partitions, memory);
			mainWindow.getPanelOptions().addPartitions();
			break;
		case BTN_START:
			verify();
		default:
			break;
		}
		
	}
	
	private void start() {
		mainWindow.getPanelOptions().start();
		loadProcess();
		variablePartition = new VariablePartition(memory, mainWindow.getPanelPartitions().getPartitions(), processes);
		loadPartitions();
		processes = variablePartition.getProcesses();
		startFixed();
	}

	private void verify() {
		switch (mainWindow.getPanelPartitions().verifyPartitions()) {
		case 1:
			messages.errorMessage(mainWindow, "El tamaño de las particiones es mayor que el de la memoria");
			break;
		case 2:
			messages.errorMessage(mainWindow, "El tamaño de las particiones es menor que el de la memoria, queda espacio sin usar");
			break;
		default:
			messages.confirmMessage(mainWindow, "Creacion satisfactoria");
			start();
			break;
		}
	}

	private void loadPartitions() {
		//Particion", "PID", "Tamaño", "Ocupación""
		ArrayList<String> partitions = new ArrayList<String>();
		for (int i = 0; i < variablePartition.getPartitions().size(); i++) {
			Partition aux = variablePartition.getPartitions().get(i);
			System.out.println("CLASS:  Controller -> Contenido de particion = " + aux.toString());
			partitions.add(aux.toString());	
		}
		mainWindow.getPanelSimulation().loadMemory(partitions);
	}

	private void startFixed() {
		task = new TimerTask() {
			
			@Override
			public void run() {
				while (variablePartition.getProcesses().isEmpty() == false) {
					System.out.println(variablePartition.getProcesses().size());
					for (int i = 0; i < variablePartition.getProcesses().size(); i++) {
						variablePartition.assing(variablePartition.getProcesses().get(i));
					}
					loadPartitions();
					updateProcess();
					variablePartition.free();
					mainWindow.getStadePane().increaste((variablePartition.getProcessesFinalized().size() * 100) / 20);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				messages.confirmMessage(mainWindow, "Simulacion Finalizada");
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
