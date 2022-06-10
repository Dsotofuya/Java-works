package modelsBatchMono;

import java.util.ArrayList;
import java.util.Iterator;

public class Execution implements IObservableMonitor{
	
	private Program program;
	private boolean isFinish;
	private String Log = "";
	private ArrayList<Finish> finishs;
	private IObserverExecutionMonitor iObserverExecutionMonitor;
	
	public Execution(String nameProgram) {
		this.program = new Program(nameProgram);
		this.finishs = new ArrayList<Finish>();
	}

	public Execution(Program program, boolean isFinish) {
		super();
		this.program = program;
		this.isFinish = isFinish;
	}
	
	
	public void executeListBatch() {
		//iterador de batchs
		int contadorBatch = 0;
		for (Iterator<Batch> iterator = program.getQueueBatch().getQueue().iterator(); iterator.hasNext();) {
			Batch batch = (Batch) iterator.next();
			int contadorSentences = 0;
			//iterador de sentences por cada batch
			for (Iterator<Sentence> iterator2 = batch.getQueueSentence().getQueue().iterator(); iterator2.hasNext();) {
				Sentence sentence = (Sentence) iterator2.next();
				this.Log = "";
				Thread threadSentence = new Thread(sentence);
				threadSentence.start();
				try {
					
					this.Log += "Programa: " + program.getName()   +"  ejecutando batch: " + contadorBatch + " instrucción: " + contadorSentences + " de " + batch.getNumSentences() + " duración: " + sentence.getTimeExecution() + " ms \n" ;
					
					synchronized (threadSentence) {
						threadSentence.sleep(sentence.getTimeExecution());
						threadSentence.join();
					}
					
					//El monitor esta escuchando la ejecución del programa
					iObserverExecutionMonitor.listeningMonitor(program.getName(), sentence);
					//saco de la cola de sentencias la que ya se ejecuto
					batch.getQueueSentence().dequeue();
					
					
					this.finishs.add(new Finish(program.getName(), (long) 1, sentence.getEnumSentence()));
					
					this.iObserverExecutionMonitor.executeProgramRender(); //aviso de un ejecucion
					
					System.out.println("programa: " + program.getName() + " sentence: " + sentence.getSentence());
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				contadorSentences ++;
			}//termina for de sentencias
			//saco de la cola el bash que se acaba de  ejecutar
			program.getQueueBatch().dequeue();
			contadorBatch++;
		}
	}
	
	public String getNameProgram() {
		return this.program.getName();
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public String getLog() {
		return Log;
	}

	public void setLog(String log) {
		Log = log;
	}

	public ArrayList<Finish> getFinishs() {
		return finishs;
	}

	public void setFinishs(ArrayList<Finish> finishs) {
		this.finishs = finishs;
	}

	@Override
	public void addObserver(IObserverExecutionMonitor iObserverExecutionMonitor) {
		this.iObserverExecutionMonitor = iObserverExecutionMonitor;
	}

}
