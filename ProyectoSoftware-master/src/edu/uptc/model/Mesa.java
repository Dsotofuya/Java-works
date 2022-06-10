package edu.uptc.model;

public class Mesa {
	private int id;
	private int cantidad_sillas;
	private boolean estado;
	
	public Mesa() {
		
	}

	public Mesa(int cantidad_sillas, boolean estado) {
		super();
		this.cantidad_sillas = cantidad_sillas;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad_sillas() {
		return cantidad_sillas;
	}

	public void setCantidad_sillas(int cantidad_sillas) {
		this.cantidad_sillas = cantidad_sillas;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
