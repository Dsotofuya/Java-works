package model;

public class FuncionTransicion {

	private char letter;
	private Estado estadoInicial;
	private Estado estadoFinal;
	
	public FuncionTransicion(char letter,Estado estadoInicial, Estado estadoFinal) {
		this.letter = letter;
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
	}
	
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public Estado getEstadoInicial() {
		return estadoInicial;
	}
	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	public Estado getEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(Estado estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	
	@Override
	public String toString() {
		return "FuncionTransicion [letter=" + letter + ", estadoInicial=" + estadoInicial + ", estadoFinal="
				+ estadoFinal + "]";
	}
	
}
