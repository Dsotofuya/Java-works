package modelsSecuential;

//Esta clase define los atributos y metodos correspondientes a la ejecución de procesos en una computadora
public class Execution extends Thread {
	private String name;
	private Program program;
	private Long reservedTime;
	private Compiler compiler;
	private Long executionTime;
	private boolean isFinish;
	private String log;

	public Execution() {

	}

	// contructor
	public Execution(String name, Program program, Long reservedTime, Long executionTime, Compiler compiler) {
		this.name = name;
		this.program = program;
		this.reservedTime = reservedTime;
		this.compiler = compiler;
		this.executionTime = executionTime;
		this.isFinish = false;
		this.log = "";
	}

	@Override
	public void run() {
		Long start = System.currentTimeMillis();
		Long timeExecutionSentence = (long) 0;
		String logSecuence = "";
		// Este mensaje se ejecuta cada vez que se ejecutará un programa
		this.log += " \n ======================================================================================="
				+ " \n \n Inicio el compilador: " + this.compiler.getName() + " \n Se ingreso: "
				+ this.program.getUtilities() + " \n Se inicia a ejecutar el programa: " + this.program.getNameProgram()
				+ " \n " + "\n executionTime: " + executionTime + " ms  reservedTime: " + reservedTime + " ms "
				+ " \n \n inicia la ejecución del programa.....";
		System.out.println(this.log);
		try {
			System.out.println();
			// Validación: si el tiempo que se reservo para el programa es suficiente para
			// ejecutar todas las instrucciones del programa
			if (executionTime < reservedTime) {
				/*
				 * Aqui se entra dado que reservamos un tiempo prudente y podemos ejecutar el
				 * programa completamente Cada programa tiene una serie de sentencias, entonces
				 * las ejecutamos y esperamos un tiempo x de espera basado en el tiempo total de
				 * ejecución
				 */
				for (int i = 0; i < this.program.getSentences().length; i++) {
					timeExecutionSentence = (executionTime / (this.program.getSentences().length)); // calculamos el
																									// tiempo de
																									// ejecucion para
																									// cada sentencia
					Thread.sleep(timeExecutionSentence);
					// Como la sentencia es ejecutada entonces se agrega al log del programa
					logSecuence = "Terminada instrucción " + (i + 1) + " de " + this.program.getSentences().length
							+ " )" + this.program.getSentences()[i] + "   tiempo de ejecución: " + timeExecutionSentence
							+ " ms \n";
					System.out.println(logSecuence);
					this.log += logSecuence;
				}
				// Las sentencias del programa han sido ejecutadas correctamente, ahora se
				// calcula el tiempo de ejecución del programa.
				logSecuence = "\n El programa " + this.program.getNameProgram()
						+ " Se ha ejecutado con exito, con un tiempo de " + (System.currentTimeMillis() - start)
						+ " ms " + " el resultado es posible leerlo en la dirección de memoria principal";
				System.out.println(logSecuence);
				this.log += logSecuence;

			} else {
				/*
				 * Aqui entramos dado que establecimos un tiempo de reserva de la maquina
				 * inferior al timepo de ejecución igual ejecutamos el programa hasta que el
				 * tiempo de reserva de la computadora nos permita
				 */
				int index = 0;
				// mientras la suma de los tiempos de ejecucion sean menor al tiempo de reserva
				// de la maquina, se calcula el tiempo de cada sentencia
				while ((timeExecutionSentence * (index + 1)) < reservedTime) {
					timeExecutionSentence = (executionTime / (this.program.getSentences().length));
					Thread.sleep(timeExecutionSentence);
					logSecuence = "instrucción " + (index + 1) + " de " + this.program.getSentences().length + " )"
							+ this.program.getSentences()[index] + "   tiempo de ejecución: " + timeExecutionSentence
							+ " ms \n";
					System.out.println(logSecuence);
					this.log += logSecuence;
					index++;
				}
				/*
				 * Cuando se determina que no se pueden ejecutar mas sentencias, dado que el
				 * tiempo de ejecucion exece al de reserva se agrega un log de error avisando de
				 * que no se pudo ejecutar todo el programa
				 */

				logSecuence = " \n ================================== Error: ============================="
						+ " \n El tiempo de ejecución del programa " + this.program.getNameProgram()
						+ " ha superado al \n"
						+ " tiempo asignado para la maquina, por favor volver a reservar un tiempo mayor de la maquina. \n"
						+ " El tiempo de ejecución fue de " + (System.currentTimeMillis() - start) + " ms ";
				System.err.println(logSecuence);
				this.log += logSecuence;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Gets y Sets
	public String getNameExecution() {
		return name;
	}

	public void setNameExecution(String name) {
		this.name = name;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Long getReservedTime() {
		return reservedTime;
	}

	public void setReservedTime(Long reservedTime) {
		this.reservedTime = reservedTime;
	}

	public Compiler getCompiler() {
		return compiler;
	}

	public void setCompiler(Compiler compiler) {
		this.compiler = compiler;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}
}
