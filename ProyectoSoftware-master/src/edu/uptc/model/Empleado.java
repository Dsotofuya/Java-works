package edu.uptc.model;

public class Empleado extends Persona{

	/*
	 * atributos propios del empleado
	 */
	private long numeroCuenta; //numero de cuenta bancaria
	private TipoEmpleo tipoEmpleo; //puesto que ocupa dentro del restaurante
	private float salario;
	

	public Empleado(long cedula, String nombres, String apellidos, long telefono, String correo, String contraseña,
			long numeroCuenta, TipoEmpleo tipoEmpleo, float salario) {
		super(cedula, nombres, apellidos, telefono, correo, contraseña);
		// TODO Auto-generated constructor stub
		this.numeroCuenta = numeroCuenta;
		this.tipoEmpleo = tipoEmpleo;
		this.salario = salario;
	}

	public Empleado() {
		
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public float getSalario() {
		return salario;
	}


	public void setSalario(float salario) {
		this.salario = salario;
	}


	public TipoEmpleo getTipoEmpleo() {
		return tipoEmpleo;
	}


	public void setTipoEmpleo(TipoEmpleo tipoEmpleo) {
		this.tipoEmpleo = tipoEmpleo;
	}


	@Override
	public String toString() {
		return getCedula() + ";" + getNombres();
	}
}
