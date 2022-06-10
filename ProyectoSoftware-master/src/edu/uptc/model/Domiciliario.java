package edu.uptc.model;

public class Domiciliario extends Persona{
	
	/*
	 * atributos propios del domiciliario
	 */
	private boolean estado;
	private Vehiculo vehiculo;
	
	public Domiciliario(long cedula, String nombres, String apellidos, long telefono, String correo, 
			String contraseña, boolean estado, Vehiculo vehiculo) {
		super(cedula, nombres, apellidos, telefono, correo, contraseña);
		// TODO Auto-generated constructor stub
		this.estado = estado;
		this.vehiculo = vehiculo;
	}
	
	public Domiciliario() {
		
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCedula() + ";" + getNombres();
	}
}
