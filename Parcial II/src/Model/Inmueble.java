package Model;

import java.util.List;

public class Inmueble {
	private String direccion;
	private String matricula;
	private TipoInmueble tipo;
	private List<Propietario> propietarios;
	private List<Oferta> ofertas;
	private int habitaciones;
	private int banios;
	private int parqueaderos;
	private int estrato; 
	private int pisos;
	
	public Inmueble(String direccion, String matricula, TipoInmueble tipo, List<Propietario> propietarios, List<Oferta> ofertas,
			int habitaciones, int banios, int parqueaderos, int estrato, int pisos) {
		super();
		this.direccion = direccion;
		this.matricula = matricula;
		this.tipo = tipo;
		this.propietarios = propietarios;
		this.ofertas = ofertas;
		this.habitaciones = habitaciones;
		this.banios = banios;
		this.parqueaderos = parqueaderos;
		this.estrato = estrato;
		this.pisos = pisos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public TipoInmueble getTipo() {
		return tipo;
	}
	public void setTipo(TipoInmueble tipo) {
		this.tipo = tipo;
	}
	public List<Propietario> getPropietarios() {
		return propietarios;
	}
	public void setPropietarios(List<Propietario> propietarios) {
		this.propietarios = propietarios;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public int getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}
	public int getBanios() {
		return banios;
	}
	public void setBanios(int banios) {
		this.banios = banios;
	}
	public int getParqueaderos() {
		return parqueaderos;
	}
	public void setParqueaderos(int parqueaderos) {
		this.parqueaderos = parqueaderos;
	}
	public int getEstrato() {
		return estrato;
	}
	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}
	public int getPisos() {
		return pisos;
	}
	public void setPisos(int pisos) {
		this.pisos = pisos;
	}
	@Override
	public String toString() {
		return "Inmueble \n direccion: " + direccion +
				"\n matricula: " + matricula +
				tipo.toString() + 
				"\n propietarios: " + propietarios.toString() +
				"\n ofertas: " + ofertas.toString() + 
				"\n habitaciones: " + habitaciones +
				"\n banios: " + banios +
				"\n parqueaderos: " + parqueaderos +
				"\n estrato: " + estrato +
				"\n pisos: " + pisos;
	}
	
	
	
} 
