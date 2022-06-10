package Model;

import java.io.Serializable;

public class student implements Serializable {

	private static final long serialVersionUID = -5211426227244693125L;
	private int numero;
	private String nombre;
	
	public student(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Paraco [numero=" + numero + ", nombre=" + nombre + "]";
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
