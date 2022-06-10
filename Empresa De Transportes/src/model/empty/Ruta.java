package model.empty;

public class Ruta {
	private int id;
	private int distancia;
	private String puntoDeInicio;
	private String puntoDeLlegada;
	
	public Ruta(){
		id = 0 ;
		distancia = 0;
		puntoDeInicio = "";
		puntoDeLlegada = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getPuntoDeInicio() {
		return puntoDeInicio;
	}

	public void setPuntoDeInicio(String puntoDeInicio) {
		this.puntoDeInicio = puntoDeInicio;
	}

	public String getPuntoDeLlegada() {
		return puntoDeLlegada;
	}

	public void setPuntoDeLlegada(String puntoDeLlegada) {
		this.puntoDeLlegada = puntoDeLlegada;
	}
	
	public String toString(){
		return "Id: " + id + "\n Distancia: " + distancia + "\n Punto de inicio: " + puntoDeInicio + "\n Punto de Llegada: " + puntoDeLlegada; 
	}
}
