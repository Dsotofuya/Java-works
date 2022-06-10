package model.empty;

import java.util.Calendar;

public abstract class Edad {
	protected String dia;
	protected String mes;
	protected String año;

	public Edad() {
		dia = "";
		mes = "";
		año = "";
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public void calcularFechaHoy() {
		Calendar c = Calendar.getInstance();
		dia = Integer.toString(c.get(Calendar.DATE));
		mes = Integer.toString(c.get(Calendar.MONTH));
		año = Integer.toString(c.get(Calendar.YEAR));

	}
	
	public abstract String calculateDates(String fecha);
}