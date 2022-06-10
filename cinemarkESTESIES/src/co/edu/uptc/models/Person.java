package co.edu.uptc.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import co.edu.uptc.controllers.Sala;

public class Person {
	
	private String name;
	private String lastName;
	private String  nDoc;
	private String tipo;
	private String sexo;
	private String edad;
	private Sala sala;
	
	public Person(){
		sala = new Sala();
	}
	
	public Person(String name, String lastName, String nDoc, String tipo, String sexo, String edad) {
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
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}

	public int calcularEdad(String fecha){
		int edad=0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fecha,fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		edad = periodo.getYears();
		return edad;
	}
	
	@Override
	public String toString() {
		return "\nNombre: " + name + " "+lastName + "\nDocumento=" + nDoc +  "\nSexo="
				+ sexo + "\nEdad=" + calcularEdad(edad) ;
	}
	
	
	

}
