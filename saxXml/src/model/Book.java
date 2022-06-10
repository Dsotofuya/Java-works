package model;

public class Book {
	private String tittle;
	private String autor;

	public Book(String tittle, String autor) {
		super();
		this.tittle = tittle;
		this.autor = autor;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
