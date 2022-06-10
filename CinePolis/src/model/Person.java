package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import control.Controller;

public class Person {
	
	private String name;
	private String lastName;
	private String  numberDoc;
	private String type;
	private String gender;
	private String age;
	private Controller controller;
	
	public Person() {
		controller = new Controller();
	}
	
	public Person(String name, String lastName, String numberDoc, String type, String gender, String age) {
		this.name = name;
		this.lastName = lastName;
		this.numberDoc = numberDoc;
		this.type = type;
		this.gender = gender;
		this.age = age;
	}
	
	public Person(String name, String lastName, String numberDoc, String type) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.numberDoc = numberDoc;
		this.type = type;
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

	public String getNumberDoc() {
		return numberDoc;
	}

	public void setNumberDoc(String numberDoc) {
		this.numberDoc = numberDoc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int calculateAge(String date){
		int age=0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate bornDay = LocalDate.parse(date,fmt);
		LocalDate now = LocalDate.now();
		Period period = Period.between(bornDay, now);
		age = period.getYears();
		return age;
	}
	
	@Override
	public String toString() {
		return "\n Nombre: " + name + " "+lastName + "\n Documento: " + numberDoc +  "\n Genero: "
				+ gender + "\n Edad:" + calculateAge(age);
	}
	
	
	

}
