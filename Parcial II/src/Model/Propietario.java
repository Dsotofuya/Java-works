package Model;

public class Propietario {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private double porcentaje;
	
	public Propietario(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			double porcentaje) {
		super();
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.porcentaje = porcentaje;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	@Override
	public String toString() {
		return "\t Primer Nombre: " + primerNombre + "\n Segundo Nombre: " + segundoNombre + "\n Primer Apellido: "
				+ primerApellido + "\n SegundoApellido: " + segundoApellido + "\n Porcentaje: " + porcentaje;
	}
	
	
}
