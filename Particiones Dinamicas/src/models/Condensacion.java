package models;

public class Condensacion {
	
	private String name;
	private static int lastId;
	private Partition partition;
	private Partition partition2;
	private Partition partition3;
	private int size;
	
	public Condensacion(Partition partition1, Partition partition2, Partition partition3) {
		lastId++;
		this.name = "C"+lastId;
		this.partition =partition1;
		this.partition2 = partition2;
		this.partition3 = partition3;
		this.size = partition1.getSize()+partition2.getSize();
	}
	
	public Condensacion(Partition partition1, Partition partition2) {
		lastId++;
		this.name = "C"+lastId;
		this.partition =partition1;
		this.partition2 = partition2;
		this.partition3 = null;
		this.size = partition1.getSize()+partition2.getSize();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

	public static int getLastId() {
		return lastId;
	}

	public Partition getPartition() {
		return partition;
	}

	public Partition getPartition2() {
		return partition2;
	}

	public Partition getPartition3() {
		return partition3;
	}

	@Override
	public String toString() {
		return name +" == "+ partition.getPartitionName() + " + "+ partition2.getPartitionName() +" = " +partition3.getPartitionName();
	}
}