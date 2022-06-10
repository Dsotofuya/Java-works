package model.entity;

public class Publicacion {

	private static int count = 0; 
	private int id;
	public String title;
	public String description;
	public String phone;
	public String img;
	public int idPublicador;
	
	public Publicacion(String title, String description, String phone, String img) {
		idPublicador = 0 ;
		this.id = count;
		this.title = title;
		this.description = description;
		this.phone = phone;
		this.img = img;
		count ++;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPhone() {
		return phone;
	}

	public String getImg() {
		return img;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void alterId(int id) {
		idPublicador = id;
	}
	
	public int getIdPublicador() {
		return idPublicador;
	}
}
