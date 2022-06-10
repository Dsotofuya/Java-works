package co.edu.uptc.models;

import java.sql.Date;

public class Person {
	
	private String name;
	private String lastName;
	private String  nDoc;
	private String tipo;
	private String sexo;
	private Date edad;
	
	public Person(){
		
	}
	
	public Person(String name, String lastName, String nDoc, String tipo, String sexo, Date edad) {
		this.name = name;
		this.lastName = lastName;
		this.nDoc = nDoc;
		this.tipo = tipo;
		this.sexo = sexo;
		this.edad = edad;
	}
	
	public Person(String name, String lastName, String nDoc, String tipo) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.nDoc = nDoc;
		this.tipo = tipo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getnDoc() {
		return nDoc;
	}
	public void setnDoc(String nDoc) {
		this.nDoc = nDoc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getEdad() {
		return edad;
	}
	public void setEdad(Date edad) {
		this.edad = edad;
	}
	
	
	

}
