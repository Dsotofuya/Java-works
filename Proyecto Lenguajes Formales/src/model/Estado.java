package model;

import java.util.ArrayList;


public class Estado {

	private String nombre;
	private boolean isInitial;
	private boolean isFinal;
	private ArrayList<FuncionTransicion> tranciociones;
	
	public Estado(String nombre, boolean isInitial, boolean isFinal){
		this.nombre = nombre;
		this.isInitial = isInitial;
		this.isFinal = isFinal;
		this.tranciociones = new ArrayList<FuncionTransicion>();
	}
	
	public void addTansactyion(FuncionTransicion transaccion) {
		this.tranciociones.add(transaccion);	
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isInitial() {
		return isInitial;
	}
	public void setInitial(boolean isInitial) {
		this.isInitial = isInitial;
	}
	public boolean isFinal() {
		return isFinal;
	}
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
	public ArrayList<FuncionTransicion> getTranciociones() {
		return tranciociones;
	}
	public void setTranciociones(ArrayList<FuncionTransicion> tranciociones) {
		this.tranciociones = tranciociones;
	}

	@Override
	public String toString() {
		return "Estado [nombre=" + nombre + ", isInitial=" + isInitial + ", isFinal=" + isFinal + ", tranciociones="
				+ tranciociones + "]";
	}
	
	
}
