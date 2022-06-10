package edu.uptc.model;

public class Persona {
	
	/*
	 * Atributos que todas las personas que interactuan en o con el sistema tiene en comun.
	 */
	private long cedula;
	private String nombres;
	private String apellidos;
	private long telefono;
	private String correo;
	private String contraseña;
	
	public Persona(long cedula, String nombres, String apellidos, long telefono, String correo, String contraseña) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	
	public Persona() {
		
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
