package edu.uptc.model;

import java.util.List;

public class Sucursal {
	
	private int id;
	private String direccion;
	private String ciudad;
	private Carta carta;
	private List<Empleado> empleados;

	public Sucursal(int id, String direccion, String ciudad, Carta carta, List<Empleado> empleados) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.carta = carta;
		this.empleados = empleados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
