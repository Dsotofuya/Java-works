package model;

public class Calculator {
	
	public Calculator() {
	
	}
	
	public double add(int x, int y){
		return Math.ceil(x + y) ;
	}
	
	public double subtract(int x, int y){
		return Math.ceil(x - y);
	}
	
	public double multiply(int x, int y){
		return Math.ceil(x * y);
	}
	
	public double divide(int x, int y){
		return Math.ceil(x / y);
		}
	 
}	