package modelsSecuential;

import java.util.ArrayList;
import java.util.Iterator;
import DataStructure.MyQueue;

public class Machine {
	private MyQueue<Execution> executions;

	// contructor
	public Machine(int programs) {
		this.executions = new MyQueue<Execution>();
		init(programs); // teniendo en cuenta la cantidad de programas, se crean mediante datos aleatorios
		showExecutions(); 
		executePrograms();
	}

	// genera los programas a ejecutar aleatoriamente y los agrega a la cola de procesos
	private void init(int cant) {
		Utilies.Utilities utilities = new Utilies.Utilities();
		for (int i = 1; i <= cant; i++) {
			this.executions.enqueue(new Execution("Ejecucion " + i,
					new Program("program " + i, "Utilidades programa de " + i, utilities.generateSentences()),
					(long) (int) (Math.random() * (20000 - 2000)) + 2000,
					(long) (int) (Math.random() * (20000 - 2000)) + 2000, new Compiler("Compilador programa: " + i)));
		}
	}

	// se desencola cada proceso de la cola para ser mostrado
	public void executePrograms() {
		if (executions.size() > 0) {
			Execution execution = executions.dequeue();
			// Si hay procesos en la cola, continua ejecutando cada uno
			while (execution != null) {
				// inicia el hilo que implementa los sleep por cada sentencia
				execution.start();
				try {
					// Mientras no termine el hilo anterior, no continua con el siguiente proceso o hilo
					execution.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Despues de la ejecución de cada programa muestre la cola de procesos actual
				showExecutions();
				// Se desencola el siguiente proceso
				execution = executions.dequeue();
			}
		}
	}

	// Muestra la ejecución de los procesos
	public void showExecutions() {
		ArrayList<Execution> list = this.executions.getQueue();
		System.out.println(" \n Estado de la cola de programas:");
		for (Iterator<Execution> iterator = list.iterator(); iterator.hasNext();) {
			Execution execution = (Execution) iterator.next();
			System.out.println("Name execution: " + execution.getNameExecution());
			System.out.println("Program: " + execution.getProgram());
			System.out.println("Compiler: " + execution.getCompiler().getName() + " \n ");
		}
	}

	// Gets y Sets
	public MyQueue<Execution> getExecutions() {
		return executions;
	}

	public void setExecutions(MyQueue<Execution> executions) {
		this.executions = executions;
	}
}
