package models;

public class Process {
	
	private String processName;
	private int processTime;
	private int processSize;
	
	public Process(String processName, int processTime, int processSize) {
		this.processName = processName;
		this.processTime = processTime;
		this.processSize = processSize;
	}

	public Process(Process process) {
		setProcessName(process.getProcessName());
		setProcessTime(process.getProcessTime());
		setProcessSize(process.getProcessSize());
	}
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public int getProcessTime() {
		return processTime;
	}

	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}

	
		
	public int getProcessSize() {
		return processSize;
	}

	public void setProcessSize(int processSize) {
		this.processSize = processSize;
	}

	public Object[] toObject(){
		return new Object[]{getProcessName(), getProcessTime(), getProcessSize()};
	}

	@Override
	public String toString() {
		return "Process [processName=" + processName + ", processTime=" + processTime + ", processSize=" + processSize
				+ "]";
	}
}