package edu.uptc.model;

public class Cliente extends Persona{
	
	/*
	 * atributos propios de un cliente
	 */
	private String direccion;
	
	public Cliente(long cedula, String nombres, String apellidos, long telefono, String correo, String contraseña, String direccion) {
		super(cedula, nombres, apellidos, telefono, correo, contraseña);
		// TODO Auto-generated constructor stub
		this.direccion = direccion;
	}
	
	public Cliente() {
		
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCedula() + ";" + getNombres();
	}
}
