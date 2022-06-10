package controller;

public enum Commands {

	BTN_START("Iniciar Simulacion","BTN_START"), 
	BTN_ADD_PARTITIONS("Agregar particiones","BTN_ADD_PARTITIONS");
	
	private String name;
	private String command;
	
	private Commands(String name, String command) {
		this.name = name;
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getName() {
		return name;
	}
}
