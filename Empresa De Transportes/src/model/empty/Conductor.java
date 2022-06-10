package model.empty;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Conductor extends Edad{
	private String fechaDeNaciemiento;
	private long cc;
	private String name;
	
	public Conductor(){
		setFechaDeNaciemiento("");
		cc = 0;
		name = "";
	}

	public long getCc() {
		return cc;
	}

	public void setCc(long cc) {
		this.cc = cc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFechaDeNaciemiento() {
		return fechaDeNaciemiento;
	}

	public void setFechaDeNaciemiento(String fechaDeNaciemiento) {
		this.fechaDeNaciemiento = fechaDeNaciemiento;
	}
	
	public String calculateDates(String fecha) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		String edad = "" + periodo.getYears();
		
		return edad;
	}
	public String toString(){
		return "Nombre: " + name + "\n Cc: " + cc + "\n Fecha de nacimiento: " + fechaDeNaciemiento + "\n Edad: " + calculateDates(fechaDeNaciemiento); 
	}
}
