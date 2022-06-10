package Model;

public class Oferta {
	private int id;
	private String nombre;
	private int valor;
	
	public Oferta(int id, String nombre, int valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Oferta: \n id: " + id + "\n nombre: " + nombre + "\n valor: " + valor;
	}
}
