package edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class Domicilio {
	
	/*
	 * Atributos necesarios para poder registrar una reserva en el sistema.
	 */
	private Cliente cliente;// datos del cliente
	private Domiciliario domiciliario;// datos del domiciliario
	private List<ItemDomicilio> itemsDomicilio;//lista de platos con su respectiva cantidad
	private float valorTotal;//valor total del domicilio
	
	public Domicilio(Cliente cliente, Domiciliario domiciliario, List<ItemDomicilio> itemsDomicilio, float valorTotal) {
		this.cliente = cliente;
		this.domiciliario = domiciliario;
		this.itemsDomicilio = new ArrayList<ItemDomicilio>();
		this.valorTotal = valorTotal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Domiciliario getDomiciliario() {
		return domiciliario;
	}
	public void setDomiciliario(Domiciliario domiciliario) {
		this.domiciliario = domiciliario;
	}

	public List<ItemDomicilio> getItemsDomicilio() {
		return itemsDomicilio;
	}

	public void setItemsDomicilio(List<ItemDomicilio> itemsDomicilio) {
		this.itemsDomicilio = itemsDomicilio;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
}