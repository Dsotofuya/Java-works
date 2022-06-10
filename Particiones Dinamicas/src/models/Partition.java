package models;

public class Partition {
	
	private String partitionName;
	private String processName;
	private boolean active;
	private int size;
	private Process process;
	private static int lastId = 0;
	
	public Partition(int size, Process process) {
		lastId++;
		this.partitionName = "PAR" + lastId;
		this.size = size;
		this.setNameProcess(process);
		this.process = process;
		this.active = true;
	}
	
	public void setNameProcess(Process process) {
		if(process != null) {
			this.processName = process.getProcessName();
		}else {
			this.processName = "NA";
		}
	}
	
	public boolean isEmpty(){
		if(process == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void desactivate(){
		this.active = false;
	}
	

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}
	
	public void lessSize(int processSize) {
		this.size -= processSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Object[] toObject(){
		return new Object[]{getPartitionName(), getSize()};
	}

	
	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public String getProcessName() {
		return processName;
	}


	public void setProcessName(String processName) {
		this.processName = processName;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public static int getLastId() {
		return lastId;
	}
	
	public boolean validateProcess(Process myProcess) {
		return false;
	}


	@Override
	public String toString() {
		return "Partition [name=" + partitionName + ", size=" + size +" Vacia: "+isEmpty()+"]";
	}
}