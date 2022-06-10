package model;

import java.util.ArrayList;

public class Memory {

	private int size;
	private ArrayList<Partition> partitions;

//	  Constructor para crear particiones de diferentes tamanios
	public Memory(int size, ArrayList<Integer> partitionsSizes) {
		this.size = size;
		setPartitions(partitionsSizes);
	}

//	Get y set
	private void setPartitions(ArrayList<Integer> partitionsSizes) {
		partitions = new ArrayList<Partition>();
		for (int i = 0; i < partitionsSizes.size(); i++) {
			partitions.add(new Partition(i, partitionsSizes.get(i)));
		}
	}

	public ArrayList<Partition> getPartitions() {
		return partitions;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
