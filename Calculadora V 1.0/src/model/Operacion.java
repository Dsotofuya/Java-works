package model;

public class Operacion {
	
	public static int suma(int x, int y){
		int suma = x + y;
		return suma;
	}
	
	public static int resta(int x, int y){
		int resta = x - y;
		return resta;
	}
	
	public static int multiplicacion(int x, int y){
		int multiplicacion = x * y;
		return multiplicacion;
	}
	
	public static int division(int x, int y){
		int division = x / y;
		return division;
	}
	
	public static int potencia(int x, int y){
		int potencia = (int) Math.pow(x, y);
		return potencia;
	}
	public void cambiarNombre( String nuevoNombre){
		Calculadora.setNombre(nuevoNombre);
	}
	
}
