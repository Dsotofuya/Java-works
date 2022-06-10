package modelsBatchMono;

import java.util.ArrayList;
import java.util.Iterator;
import DataStructure.MyQueue;
import controller.IObservableMonitorController;
import controller.IObserverMonitorController;

public class MaquineBatchMono implements IObserverExecutionMonitor, IObservableMonitorController{
	
	private MyQueue<Execution> queueExecution;
	private MainMemory mainMemory;
	private IObserverMonitorController iObserverMonitorController;
	
	public MaquineBatchMono(int cant,IObserverMonitorController iObserverMonitorController) {
		this.mainMemory = new MainMemory();
		this.iObserverMonitorController = iObserverMonitorController;
		this.queueExecution = new MyQueue<Execution>();
		init(cant);
		//show();
	}
	

	public MaquineBatchMono(MyQueue<Execution> queueExecution, MainMemory mainMemory) {
		this.queueExecution = queueExecution;
		this.mainMemory = mainMemory;
	}
	
	private void init(int cant) {
		for (int i = 0; i < cant; i++) {
			Execution execution = new Execution("Program " + (i + 1));
			execution.addObserver(this); //agrego el observador a la ejecucion
			this.queueExecution.enqueue(execution);
		}
	}
	
	public void executePrograms() {
		for (Iterator<Execution> iterator = this.queueExecution.getQueue().iterator(); iterator.hasNext();) {
			this.mainMemory.resetMonitor();
			Execution Execution = (Execution) iterator.next();
			Execution.executeListBatch();
			
		}
	}
	
	public void show() {
		
		for (int g = 0; g < this.queueExecution.size(); g++) {
			System.out.println("nombre del programa: " + this.queueExecution.getQueue().get(g).getNameProgram());
			
			ArrayList<Batch> batchs = this.queueExecution.getQueue().get(g).getProgram().getQueueBatch().getQueue();
			for (int i = 0; i < batchs.size(); i++) {
				for (int j = 0; j < batchs.get(i).getQueueSentence().size(); j++) {
					System.out.println(batchs.get(i).getQueueSentence().getQueue().get(j).getSentence());
				}
			}
			
		}
		
	}

	public MyQueue<Execution> getQueueExecution() {
		return queueExecution;
	}

	public void setQueueExecution(MyQueue<Execution> queueExecution) {
		this.queueExecution = queueExecution;
	}

	public MainMemory getMainMemory() {
		return mainMemory;
	}

	public void setMainMemory(MainMemory mainMemory) {
		this.mainMemory = mainMemory;
	}


	@Override
	public void executeProgramRender() {
		System.out.println("Estan ejecutando algo");
		this.iObserverMonitorController.executeProgramRender();
	}


	@Override
	public void addIObserverMonitorController(IObserverMonitorController iObserverMonitorController) {
		this.iObserverMonitorController = iObserverMonitorController;
	}


	@Override
	public void listeningMonitor(String nameProgram, Sentence sentence) {
		this.mainMemory.validateSentence(nameProgram, sentence);
	}	
	
	

}
