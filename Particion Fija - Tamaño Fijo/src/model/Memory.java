package model;

import java.util.ArrayList;

public class Memory {

	private int size;
	private ArrayList<Partition> partitions;


// Constructor para crear particiones de igual tamano
	public Memory(int size, int numberOfPartitions) {
		this.size = size;
		this.partitions = new ArrayList<Partition>();
		setPartitions(calculateSizes(numberOfPartitions));
	}

	 // Metodo para poder calcular el tamanio que van a tener todas las particiones en la particion fija
	private ArrayList<Integer> calculateSizes(int numberOfPartitions) {
		ArrayList<Integer> particionList = new ArrayList<Integer>();
		int sizePartition = (int) size / numberOfPartitions;
		for (int i = 0; i < numberOfPartitions; i++) {
			particionList.add(sizePartition);
		}
		return particionList;
	}

	//Set y get 
	private void setPartitions(ArrayList<Integer> partitionsSizes) {
		partitions = new ArrayList<Partition>();
		for (int i = 0; i < partitionsSizes.size(); i++) {
			partitions.add(new Partition(i, partitionsSizes.get(i)));
		}
	}

	public ArrayList<Partition> getPartitions() {
		return partitions;
	}
}
