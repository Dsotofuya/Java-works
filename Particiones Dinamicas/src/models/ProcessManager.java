package models;

import java.util.ArrayList;
import java.util.Comparator;

import doubleSimpleList.DoubleSimpleList;
import doubleSimpleList.Node;
import structure.Queue;

public class ProcessManager {

	public static final int TIME_PROCESS = 1;
	public int sizeMemory; 
	
	private DoubleSimpleList<Partition> partitionList;
	private ArrayList<Condensacion> consensacionesList;
	private Queue<Process> processList;
	private ArrayList<Process> fireList;
	private ArrayList<Process> exitProcessList;
	private ArrayList<Partition> exitPartitionList;
	@SuppressWarnings("unused")
	private ArrayList<ProcessInfo> info;
	@SuppressWarnings("unused")
	private ArrayList<PartitionInfo> infoPartitions;

	public ProcessManager(int sizeMemory) {
		partitionList = new DoubleSimpleList<Partition>();
		processList = new Queue<Process>();
		fireList = new ArrayList<Process>();
		infoPartitions = new ArrayList<PartitionInfo>();
		consensacionesList = new ArrayList<Condensacion>();
		exitProcessList = new ArrayList<Process>();
		exitPartitionList = new ArrayList<Partition>();
		this.sizeMemory = sizeMemory;
		//test();
	}
	
	public void setSizeMemory(int sizeMemory) {
		this.sizeMemory = sizeMemory;
	}
	
	public void test() {
		addProcess("P18", 6, 18);
		addProcess("P40", 3, 40);
		addProcess("P4", 8, 4);
		addProcess("P15", 7, 15);
		addProcess("P50", 4, 50);
	}

	public Process addProcess(String processName, int processTime, int processSize){
		Process process = new Process(processName, processTime, processSize);
		processList.put(process);
		processList.addToHistorial(process);
		return process;
	}

	public Partition addPartition(int size, Process process) {
		Partition partition = new Partition(size, process);
		partitionList.add(partition);
		partitionList.addToHistorial(partition);
		return partition;
	}

	public void insertPartition(Partition partition) {
		partitionList.add(partition);
		partitionList.addToHistorial(partition);
	}
	
	public void addPartition(Node<Partition> current, Node<Partition> current2) {
		partitionList.add(current, current2);
	}
	
	public void addCondensationNext1(Node<Partition> current,Node<Partition> current2){
		partitionList.addNextCondensation1(current, current2);
	}
	
	public void addNextPartition(Node<Partition> current,Node<Partition> current2){
		System.out.println("Entro");
		partitionList.addNextPartition(current, current2);
	}
	
	public void addCondensationNext(Node<Partition> current,Node<Partition> current2){
		partitionList.addNextCondensation(current, current2);
	}
	

	public void addCondensationPrevius(Node<Partition> current,Node<Partition> current2){
		partitionList.addPrevCondensation(current, current2);
	}
	
	public void addCondensationPrevius1(Node<Partition> current,Node<Partition> current2){
		partitionList.addPrevCondensation1(current, current2);
	}

	public void addCondensacion(Condensacion condensacion){
		this.consensacionesList.add(condensacion);
	}
	
	public void addProcessFinish(Process myProcess){
		exitProcessList.add(myProcess);
	}
	
	public void addPartitionFinish(Partition partition){
		exitPartitionList.add(partition);
	}
	
	public int getLisPartitionSize(){
		int size=0;
		Node<Partition> current = partitionList.getHead();
		while (current !=null) {
			size += current.getInfo().getSize(); 
			current = current.getNext();
		}
		return size;
	}
	
	public void remove(String info){
		if (info != processList.getFirst().getInfo().getProcessName()) {
			System.out.println("Entro");
			structure.Node<Process> current = processList.getFirst();
			structure.Node<Process> before = processList.getFirst();
			while((current != null) && !current.getInfo().getProcessName().equalsIgnoreCase(info)){
				before = current;
				current = current.getNext();
				System.out.println("Lo encontro");
			}
			if (current!=null) {
				before.setNext(current.getNext());
			}
		}else{
			System.out.println("Lo borro");
			processList.setFirst(processList.getFirst().getNext());
		}
	}
	
	public boolean processExist(String name){
		for (int i = 0; i < processList.getHistorial().size(); i++) {
			if (processList.getHistorial().get(i).getProcessName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteToNoProcess(Process myProcess){
		for (int i = 0; i < fireList.size(); i++) {
			if (myProcess.getProcessName().equalsIgnoreCase(fireList.get(i).getProcessName())) {
				fireList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void rebootList(){
		this.partitionList.reset();
		this.processList.resetHistorial();
		this.fireList.clear();
	}

	public void excecuteProcess() {
		ArrayList<Node<Partition>> partitioInOrder = new ArrayList<>();
		Node<Partition> current = getPartititonList().getHead();
		while(current!=null){
			if (current.getInfo().isActive()&&!current.getInfo().isEmpty()) {
				partitioInOrder.add(current);
			}
			current = current.getNext();
		}
		partitioInOrder.sort(new Comparator<Node<Partition>>() {
			@Override
			public int compare(Node<Partition> o1, Node<Partition> o2) {
				return o1.getInfo().getProcess().getProcessTime()-o2.getInfo().getProcess().getProcessTime();
			}
		});

		for (int i = 0; i < partitioInOrder.size(); i++) {
			partitioInOrder.get(i).getInfo().getProcess().setProcessTime(partitioInOrder.get(i).getInfo().getProcess().getProcessTime() - TIME_PROCESS);
			if (partitioInOrder.get(i).getInfo().getProcess().getProcessTime()<=0) {
				addProcessFinish(partitioInOrder.get(i).getInfo().getProcess());
				addPartitionFinish(partitioInOrder.get(i).getInfo());
				partitioInOrder.get(i).getInfo().setProcess(null);
				System.out.println("Esta es la cabeza "+ getPartititonList().getHead().getInfo());
				System.out.println("Esta es el ultimo "+ getPartititonList().getLast().getInfo());
				System.out.println("ESTE ES EL ACTUAL EN EJEC "+partitioInOrder.get(i).getInfo());
				makeCondesations(partitioInOrder.get(i));
			}
		}
	}
	
	public void makeCondesations(Node<Partition> partition){
		if (partition.getInfo().getSize()< sizeMemory) {
			if (partition.getInfo().getPartitionName() != getPartititonList().getHead().getInfo().getPartitionName() && partition.getInfo().getPartitionName() != getPartititonList().getLast().getInfo().getPartitionName()) {
				if(partition.getInfo() != null) {
					if (partition.getNext().getInfo().isEmpty()	&& partition.getNext().getInfo().getPartitionName() != getPartititonList().getLast().getInfo().getPartitionName()) {
						int sizeNewPartition = partition.getInfo().getSize()+partition.getNext().getInfo().getSize();
						Node<Partition> newNode = new Node<Partition>(new Partition(sizeNewPartition, null));
						getPartititonList().addToHistorial(newNode.getInfo());
						this.condensarNodoHaciaAbajo(partition, partition.getNext(), newNode);
						Condensacion condensacion = new Condensacion(partition.getInfo(), partition.getNext().getInfo(),newNode.getInfo());
						System.out.println("Estamos en la mitad y sigiente y no ultimo");
						System.out.println("Condensacion" +condensacion.toString()+"\n");
						this.addCondensacion(condensacion);
						this.makeCondesations(newNode);

					}else if (partition.getNext().getInfo().isEmpty()&&partition.getNext().getInfo().getPartitionName() == getPartititonList().getLast().getInfo().getPartitionName()) {
						int sizeNewPartition = partition.getInfo().getSize()+partition.getNext().getInfo().getSize();
						Node<Partition> newNode = new Node<Partition>(new Partition(sizeNewPartition, null));
						getPartititonList().addToHistorial(newNode.getInfo());
						this.condensarNodoHaciaAbajo2(partition, partition.getNext(), newNode);
						Condensacion condensacion = new Condensacion(partition.getInfo(), partition.getNext().getInfo(),newNode.getInfo());
						System.out.println("Estamos en la mitad y sigiente y ultimo");
						System.out.println("Condensacion" +condensacion.toString()+"\n");
						addCondensacion(condensacion);
						this.makeCondesations(newNode);

					}else if (partition.getPrevius().getInfo().isEmpty() && partition.getPrevius().getInfo().getPartitionName() != getPartititonList().getHead().getInfo().getPartitionName()){
						int sizeNewPartition = partition.getInfo().getSize()+partition.getPrevius().getInfo().getSize();
						Node<Partition> newNode = new Node<Partition>(new Partition(sizeNewPartition, null));
						getPartititonList().addToHistorial(newNode.getInfo());
						System.out.println(partition);
						System.out.println(partition.getPrevius());
						System.out.println(newNode);
						this.condensarNodoHaciaArriba(partition, partition.getPrevius(), newNode);
						Condensacion condensacion = new Condensacion(partition.getInfo(), partition.getPrevius().getInfo(),newNode.getInfo());
						System.out.println("Estamos en la mitad y anterior y no primero");
						System.out.println("Condensacion" +condensacion.toString()+"\n");
						addCondensacion(condensacion);
						this.makeCondesations(newNode);

					}else if (partition.getPrevius().getInfo().isEmpty()&&partition.getPrevius().getInfo().getPartitionName() == getPartititonList().getHead().getInfo().getPartitionName()){

						int sizeNewPartition = partition.getInfo().getSize()+partition.getPrevius().getInfo().getSize();
						Node<Partition> newNode = new Node<Partition>(new Partition(sizeNewPartition, null));
						getPartititonList().addToHistorial(newNode.getInfo());
						this.condensarNodoHaciaArriba2(partition, partition.getPrevius(), newNode);
						Condensacion condensacion = new Condensacion(partition.getInfo(), partition.getPrevius().getInfo(),newNode.getInfo());
						System.out.println("Estamos en la mitad  anterior y primero");
						System.out.println("Condensacion" +condensacion.toString()+"\n");
						addCondensacion(condensacion);
						this.makeCondesations(newNode);
					}
				}else {
					System.out.println(" :(");
				}
				
			}else if (partition.getInfo().getPartitionName() == getPartititonList().getHead().getInfo().getPartitionName()) {
				if (getPartititonList().getSize()==1) {
					System.out.println(partition.toString());
				}else if (partition.getNext().getInfo().isEmpty()) {
					if(getPartititonList().getSize() == 1) {
						System.out.println(partition.toString());
					}else {
						int sizeNewPartition = partition.getInfo().getSize()+partition.getNext().getInfo().getSize();
						Node<Partition> newNode = new Node<Partition>(new Partition(sizeNewPartition, null));
						getPartititonList().addToHistorial(newNode.getInfo());
						this.condensarHead(partition, partition.getNext(), newNode);
						Condensacion condensacion = new Condensacion(partition.getInfo(), partition.getNext().getInfo(),newNode.getInfo());
						System.out.println("Estamos en la cabeza y sigiente ");
						System.out.println("Condensacion" +condensacion.toString()+"\n");
						addCondensacion(condensacion);
						this.makeCondesations(newNode);
					}
				}
			}else if (partition.getInfo().getPartitionName() == getPartititonList().getLast().getInfo().getPartitionName()) {
				if (getPartititonList().getSize() == 1) {
					System.out.println(partition.toString());
				} else if (partition.getPrevius().getInfo().isEmpty()) {
					int sizeNewPartition = partition.getInfo().getSize()+partition.getPrevius().getInfo().getSize();
					Node<Partition> newNode = new Node<Partition>(new Partition(sizeNewPartition, null));
					getPartititonList().addToHistorial(newNode.getInfo());
					this.condensarLast(partition, partition.getPrevius(), newNode);
					Condensacion condensacion = new Condensacion(partition.getInfo(), partition.getPrevius().getInfo(),newNode.getInfo());
					System.out.println("Estamos en el ultimo y anterior");
					System.out.println("Condensacion" +condensacion.toString()+"\n");
					addCondensacion(condensacion);
					this.makeCondesations(newNode);
				}
			}else{
				System.out.println("No condenso");
			}
		}
	}
	
	public void condensarHead(Node<Partition> partition1, Node<Partition> partition2, Node<Partition> newNode){
		newNode.setNext(partition2.getNext());
		newNode.setPrevius(null);
		partition1.getInfo().desactivate();
		partition2.getInfo().desactivate();
		getPartititonList().setHead(newNode);
		getPartititonList().setLast(newNode);
	}

	public void condensarLast(Node<Partition> partition1, Node<Partition> partition2, Node<Partition> newNode){
		newNode.setNext(null);
		if (partition2.getPrevius()!=null) {
			newNode.setPrevius(partition2.getPrevius());
			partition2.getPrevius().setNext(newNode);
		}else{
			newNode.setPrevius(null);
			getPartititonList().setHead(newNode);
		}
		partition1.getInfo().desactivate();
		partition2.getInfo().desactivate();
		getPartititonList().setLast(newNode);
	}

	public void condensarNodoHaciaAbajo(Node<Partition> partition1, Node<Partition> partition2, Node<Partition> newNode){
		newNode.setNext(partition2.getNext());
		newNode.setPrevius(partition1.getPrevius());
		partition1.getPrevius().setNext(newNode);
		if (partition2.getNext()!=null) {
			partition2.getNext().setPrevius(newNode);
		}
		partition1.getInfo().desactivate();
		partition2.getInfo().desactivate();
	}

	public void condensarNodoHaciaAbajo2(Node<Partition> partition1, Node<Partition> partition2, Node<Partition> newNode){
		newNode.setNext(null);
		newNode.setPrevius(partition1.getPrevius());
		partition1.getPrevius().setNext(newNode);
		partition1.getInfo().desactivate();
		partition2.getInfo().desactivate();
		getPartititonList().setLast(newNode);
	}

	public void condensarNodoHaciaArriba(Node<Partition> partition1, Node<Partition> partition2, Node<Partition> newNode){
		newNode.setNext(partition1.getNext());
		newNode.setPrevius(partition2.getPrevius());
		partition2.getPrevius().setNext(newNode);
		partition1.getNext().setPrevius(newNode);
		partition1.getInfo().desactivate();
		partition2.getInfo().desactivate();
	}
	
	public void condensarNodoHaciaArriba2(Node<Partition> partition1, Node<Partition> partition2, Node<Partition> newNode){
		newNode.setNext(partition1.getNext());
		newNode.setPrevius(null);
		partition1.getNext().setPrevius(newNode);
		partition1.getInfo().desactivate();
		partition2.getInfo().desactivate();
		getPartititonList().setHead(newNode);
	}
	
	public boolean addProcessToPartition(Process myProcess){
		Node<Partition> current = getPartititonList().getHead();
		while(current!=null){
			if (current.getInfo().isEmpty()&& current.getInfo().isActive()) {
				if (current.getInfo().getSize() >= myProcess.getProcessSize()) {
					int size = current.getInfo().getSize();
					Node<Partition> current2 = new Node<Partition>(new Partition(myProcess.getProcessSize(), myProcess));
					addNextPartition(current, current2);
					if ( (size-myProcess.getProcessSize()) > 0 ) {
						Node<Partition> current3 = new Node<Partition>(new Partition( size-myProcess.getProcessSize() , null));
						addPartition(current2, current3);
					}
					current.getInfo().desactivate();
					return true;
				}
			}
			current = current.getNext();
		}
		return false;
	}
	
	public ArrayList<Process> llenarUno(){

		ArrayList<Process> listAux= new ArrayList<>();
		while (true) {
			if (getProcessList().size()>0) {
				listAux.add(getProcessList().get());
			}else{
				return listAux;
			}
		}	
	}
	
	public void agregarAuno(){
		int size1 = getLisPartitionSize();
		ArrayList<Process> listAux= this.llenarUno();
		for (int i = 0; i < listAux.size(); i++) {
			addPartition(listAux.get(i).getProcessSize(), listAux.get(i));
		}
		getPartititonList().setHead(getPartititonList().getHead().getNext());
		if (getLisPartitionSize() < size1) {
			int size = size1 - getLisPartitionSize();
			addPartition(size, null);
		}
		getPartititonList().print();
	}
	
	public void ejecutar(){
		this.splitPartition();
		System.out.println("************LISTAA****************");
		getPartititonList().print();
		System.out.println("****************************");

		while(!(getProcessList().getHistorial().size() == getExitProcessList().size())){
			if (getProcessList().size()>0) {
				Process processAux = getProcessList().get();
				System.out.println("Proceso Actual"+ processAux);
				boolean agrego = false;
				while (agrego!=true) {
					System.out.println("************LISTAA.....****************");
					getPartititonList().print();
					System.out.println("###TAMA�O### "+ getPartititonList().getSize());
					System.out.println("****************************");
					if (getPartititonList().getSize()>1) {
						if (this.addProcessToPartition(processAux)) {
							System.out.println("Entro A agregar");
							agrego =true;
						}else{
							this.excecuteProcess();
						}	
					}else{
						System.out.println("Estamos en 1");
						getProcessList().colar(processAux);
						this.agregarAuno();
						agrego = true;
					}
				}
			}else{
				this.excecuteProcess();
			}
		}
		this.printHistorials();
	}
	
	public void printHistorials(){
		System.out.println("PROCESOS ENTRADA----------------------");
		for (int i = 0; i < getProcessList().getHistorial().size(); i++) {
			System.out.println(getProcessList().getHistorial().get(i).toString());
		}
		System.out.println("---------------------------------");

		System.out.println("PARTICIONES----------------------");
		for (int i = 0; i < getPartititonList().getHistorial().size(); i++) {
			System.out.println(getPartititonList().getHistorial().get(i).toString());
		}
		System.out.println("---------------------------------");
		System.out.println("CONDENSACIONES-------------------");
		for (int i = 0; i < getCondensacionesList().size(); i++) {
			System.out.println(getCondensacionesList().get(i).toString());
		}
		System.out.println("---------------------------------");

		System.out.println("PROCESOS FINALIZADOS-------------------");
		for (int i = 0; i < getExitProcessList().size(); i++) {
			System.out.println(getExitProcessList().get(i).toString());
		}
		System.out.println("---------------------------------");
		System.out.println("PARTICIONES FINALIZADOS-------------------");

		for (int i = 0; i < getExitPartitionList().size(); i++) {
			System.out.println(getExitPartitionList().get(i).toString());
		}
		System.out.println("---------------------------------");

	}

	public Queue<Process> getProcessList() {
		return processList;
	}

	public DoubleSimpleList<Partition> getPartititonList(){
		return partitionList;
	}

	public ArrayList<Process> getFireList() {
		return fireList;
	}

	public ArrayList<Process> getExitProcessList() {
		return exitProcessList;
	}

	public ArrayList<Condensacion> getCondensacionesList() {
		return consensacionesList;
	}

	public ArrayList<Partition> getExitPartitionList() {
		return exitPartitionList;
	}
	
	public void splitPartition(){
		while (true) {
			if (getProcessList().size()>0) {
				Process processAux = getProcessList().get();
				if ( (getLisPartitionSize() + processAux.getProcessSize()) <= sizeMemory) {
					addPartition(processAux.getProcessSize(), processAux);
				}else if ((sizeMemory - getLisPartitionSize()) >0) {
					addPartition( sizeMemory - getLisPartitionSize(), null);
					getProcessList().colar(processAux);
					return;
				}else{
					getProcessList().colar(processAux);
					return;
				}
			}else if( (sizeMemory - getLisPartitionSize()) > 0 ){
				addPartition(sizeMemory - getLisPartitionSize(), null);
				return;
			}
		}
	}
	
	public int getSizeMemory() {
		return sizeMemory;
	}
}