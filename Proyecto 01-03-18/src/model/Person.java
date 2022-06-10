package model;

import model.DocType;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
	
	public String name;
	public String lastName;
	public DocType docType;
	public int docNumber;
	public String gender;
	public String bornDay;
	
	
	public Person(String name, String lastName, DocType docType, int docNumber, String gender, String bornDay) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.docType = docType;
		this.docNumber = docNumber;
		this.gender = gender;
		this.bornDay = bornDay;
	}

	public String getBornDay() {
		return bornDay;
	}

	public void setBornDay(String bornDay) {
		this.bornDay = bornDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public int getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(int docNumber) {
		this.docNumber = docNumber;
	}

	//Metodo para calcular la edad;
	
	public String calculateAge(String date) {
		
		//usa DateTimeFormatter para asignar un formato de fecha personaliazdo 
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//Trasnforma a local date un string, en este caso la fecha y el formato en el que viene
		
		LocalDate fechaNac = LocalDate.parse(date, format);
		
		//Obtiene la fecha actual
		LocalDate now = LocalDate.now();
		
		//obtiene una costante periodo entre dos fechas
		Period period = Period.between(fechaNac, now);
		
		//Realiza los calculos y retorna una edad
		String age = "" + period.getYears();
		
		return age;
	}
	
}
