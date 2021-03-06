package model;

public enum State {

	FINALIZED("Finalizado"), IN_PROGRESS("En proceso"), WAITING("Esperando");
	
	private String name;
	
	private State(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
