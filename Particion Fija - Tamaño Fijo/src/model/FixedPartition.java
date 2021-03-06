package model;

import java.util.ArrayList;

public class FixedPartition {

	public static final int NUMBER_OF_PROCESS = 20;
	private Memory memory;
	private ArrayList<Partition> partitions;
	private ArrayList<Process> processes;
	private ArrayList<Process> processesFinalized;

//	Constructor
	public FixedPartition(int sizeMemory, int partitions, ArrayList<Process> processes) {
		memory = new Memory(sizeMemory, partitions);
		this.partitions = memory.getPartitions();
		this.processes = new ArrayList<Process>();
		this.processes = processes;
		processesFinalized = new ArrayList<Process>();
		System.out.println("CLASS: FixedPartition -> Tamanio de Datos " + sizeMemory + "  , particiones " + partitions
				+ ", tamanio de particion" + memory.getPartitions().get(0).getTotalSize() + ", procesos"
				+ processes.size());
	}

	// Metodo que asigna un proceso a una particion que este disponible
	public void assing(Process process) {
		if (process.isAssigned() == true) {
			return;
		}
		for (int i = 0; i < partitions.size(); i++) {
			if (process.getSize() <= 0) {
				process.setStade(State.FINALIZED);
				processes.remove(process);
				processesFinalized.add(process);
				return;
			}
			if (partitions.get(i).isBusy() == false) {
				partitions.get(i).setProcess(process);
				System.out.println("CLASS: FixedPartition -> El proceso " + process.getId() + "[" + process.getSize()
						+ "]" + " ha sido asignado a la particion " + partitions.get(i).getId() + " ["
						+ partitions.get(i).getFreeSize() + "]");
				process.execute(partitions.get(i).getTotalSize());
				return;
			}
		}
	}

	// muestra cuando una partición fue liberada
	public void free() {
		for (int i = 0; i < partitions.size(); i++) {
			if (partitions.get(i).isBusy()) {
				partitions.get(i).free();
				System.err.println("CLASS: FixedPartition --> [Particion " + partitions.get(i).getId()
						+ " liberada]");
			}
		}
	}

	//Getters
	public ArrayList<Process> getProcesses() {
		return processes;
	}

	public ArrayList<Partition> getPartitions() {
		return partitions;
	}

	public ArrayList<Process> getProcessesFinalized() {
		return processesFinalized;
	}

}
