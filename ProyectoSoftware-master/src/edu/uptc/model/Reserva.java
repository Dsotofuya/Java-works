package edu.uptc.model;

import java.util.Date;

public class Reserva {
	private int id;
	private int mesa;
	private long cliente;
	private int numero_personas;
	private Date fecha_hora;
	
	public Reserva() {
		
	}

	public Reserva(int id, int mesa, long cliente, int numero_personas, Date fecha_hora) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.cliente = cliente;
		this.numero_personas = numero_personas;
		this.fecha_hora = fecha_hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public long getCliente() {
		return cliente;
	}

	public void setCliente(long cliente) {
		this.cliente = cliente;
	}

	public int getNumero_personas() {
		return numero_personas;
	}

	public void setNumero_personas(int numero_personas) {
		this.numero_personas = numero_personas;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", mesa=" + mesa + ", cliente=" + cliente + ", numero_personas=" + numero_personas
				+ ", fecha_hora=" + fecha_hora + "]";
	}
}
