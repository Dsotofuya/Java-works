package model.empty;

import java.util.Calendar;

public abstract class Edad {
	protected String dia;
	protected String mes;
	protected String a�o;

	public Edad() {
		dia = "";
		mes = "";
		a�o = "";
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

	public String getA�o() {
		return a�o;
	}

	public void setA�o(String a�o) {
		this.a�o = a�o;
	}

	public void calcularFechaHoy() {
		Calendar c = Calendar.getInstance();
		dia = Integer.toString(c.get(Calendar.DATE));
		mes = Integer.toString(c.get(Calendar.MONTH));
		a�o = Integer.toString(c.get(Calendar.YEAR));

	}
	
	public abstract String calculateDates(String fecha);
}