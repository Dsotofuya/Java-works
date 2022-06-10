package edu.uptc.model;

/*
 * Esta clase sera la encargada de contener un plato y la cantidad de este que pedira elm cliente
 */
public class ItemDomicilio {
	private Plato plato;
	private int cantidad;
	
	public ItemDomicilio(Plato plato, int cantidad) {
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
