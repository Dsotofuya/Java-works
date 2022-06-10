package model;

public class Process {

	private String PID;
	// tamaño de 4 hasta 512 MB
	private int size;
	private State stade;
	private boolean assigned;
	private int sizeCompleted;
	
	public Process(String PID, int size) {
		this.PID = PID;
		this.size = size;
		this.stade = State.WAITING;
		this.assigned = false;
		this.sizeCompleted = 0;
	}
	
	public void execute(int size) {
		this.sizeCompleted = size;
		this.size = this.size - sizeCompleted;
		this.stade = State.IN_PROGRESS;
	}

	public String getId() {
		return PID;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return PID + "," + size + "," + stade.getName() + "," + sizeCompleted;
	}
	
	

	public String getPID() {
		return PID;
	}

	public void setStade(State stade) {
		this.stade = stade;
	}

	public boolean isAssigned() {
		return assigned;
	}
}
