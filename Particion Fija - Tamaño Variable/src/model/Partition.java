package model;

public class Partition extends Thread {

	private int id;
	private Process process;
	private int totalSize;
	private int usedSize;
	private int freeSize;
	private boolean busy;

//	Constructor
	public Partition(int id, int totalSize) {
		super();
		this.id = id;
		this.totalSize = totalSize;
		this.usedSize = 0;
		this.freeSize = totalSize;
		this.busy = false;
	}

//	  Metodo que agrega un proceso a la particion
	public void setProcess(Process process) {
		if (process.getSize() > totalSize) {
			freeSize = 0;
			usedSize = totalSize;
			process.execute(totalSize);
			this.busy = true;
		} else {
			usedSize = process.getSize();
			freeSize = totalSize - usedSize;
			this.busy = true;
		}
		this.process = process;
	}

//	  Metodo que libera a la particion del proceso
	public void free() {
		usedSize = 0;
		freeSize = totalSize;
		process = null;
		busy = false;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getFreeSize() {
		return freeSize;
	}

	public long getId() {
		return id;
	}

	public boolean isBusy() {
		return busy;
	}

	@Override
	public String toString() {
		if (process == null) {
			return id + "," + " " + "," + totalSize + "," + usedSize;
		}
		return id + "," + process.getPID() + "," + totalSize + "," + usedSize;
	}

}
