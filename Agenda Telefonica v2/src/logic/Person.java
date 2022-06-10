package logic;

public class Person {
	@Override
	public String toString() {
		return "Person [nombre=" + nombre + ", numero=" + numero + ", ciudad=" + ciudad + "]";
	}


	private String nombre;
	private int numero;
	private String ciudad;

	public Person() {
		nombre="";
		numero = 0;
		ciudad = "";
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
