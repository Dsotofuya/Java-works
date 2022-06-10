package model.empty;

public class Vehiculo {
	private String estado;
	private String placa;
	private int combustible;
	private int numeroDePasajeros;
	private String modelo;
	private Ruta ruta;
	private Conductor conductor;
	protected double tarifa;

	public Vehiculo() {
		setEstado("");
		placa = "";
		combustible = 0;
		numeroDePasajeros = 0;
		modelo = "";
		tarifa = 0.0;
	}

	public int consumoDeCombustible() {
		int combustibleRestante = ruta.getDistancia() - getCombustible();
		return combustibleRestante;
	}

	public void calcularEstado() {
		if ((conductor == null) && ( ruta == null)) {
			setEstado("El bus no esta en funcionamiento");
		} else {
			
			setEstado("El bus esta en funcionamiento");
		}
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCombustible() {
		return combustible;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public int getNumeroDePasajeros() {
		return numeroDePasajeros;
	}

	public void setNumeroDePasajeros(int numeroDePasajeros) {
		this.numeroDePasajeros = numeroDePasajeros;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
