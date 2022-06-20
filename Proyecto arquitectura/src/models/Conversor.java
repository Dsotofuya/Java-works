package models;

/**
 * Clase encargada de convertir caulquier número desde cualquier base
 * a cualquier base (máximo base 36)
 * 
 * @author Jhose :D
 */

import java.util.HashMap;


public class Conversor {
	
	private HashMap<Integer, String> parseNumber;
	private HashMap<Character, Integer> parseLetter;
	private Constants constants;
	
	
	/**
	 * Constructor donde se llama la base Constants.
	 * Llama la equivalencia de letras con números.
	 */
	public Conversor() {
		constants = new Constants();
		parseNumber = constants.getParse();
		parseLetter = constants.getParseLetter();
	}
	
	/**
	 * Convierte cualquier número en la base que se desee a cuaquier base
	 * @param number. Número a convertir
	 * @param initialBase. Base del número ingresado
	 * @param finalBase. Base a la que se quiere convertir
	 * @param trunk. Número de decimales que se quieren tomar al final
	 * @return Número en la base ingresada con la precisión ingresada
	 */
	public String conversor(String number, int initialBase, int finalBase, int trunk )
	{
		if (number.charAt(0) != '-') {
			if (number.equals("0")) {
				return number;
			}else if (initialBase == 10) {
				return convertDecimalToBase(number,finalBase, trunk );
			}else {
				return convertDecimalToBase(convertBaseToDecimal(number, initialBase),finalBase, trunk);
			}
		}else {
			if (number.equals("0")) {
				return number;
			}else if (initialBase == 10) {
				return "-"+convertDecimalToBase(number.substring(1),finalBase, trunk );
			}else {
				return "-"+convertDecimalToBase(convertBaseToDecimal(number.substring(1), initialBase),finalBase, trunk);
			}
		}
		
	}

	/**
	 * Convierte el número con la base ingresada a decimal
	 * @param number. Número a convertir
	 * @param initialBase. Base del número ingresado
	 * @return Número en base decimal
	 */
	private String convertBaseToDecimal(String number, int initialBase) {
		if (validateFloat(number)) {
			String[] aux = number.split("\\.");
			return "" + ((double)convertInteger(aux[0], initialBase) + convertFloat(aux[1], initialBase));
		}else {
			return "" + convertInteger(number, initialBase);
		}
	}
	
	/**
	 * Convierte la base entera a base 10
	 * @param string. Parte entera de un número
	 * @param initialBase. Base del número ingresado
	 * @return Parte entera en base diez.
	 */
	private int convertInteger(String string, int initialBase) {
		System.out.println(string);
		int[] digits = parseChar(string.toCharArray());
		int integer = 0;
	    int pow = digits.length-1;
	    for (int i = 0; i < digits.length; i++) {
			integer += digits[i]*Math.pow(initialBase, pow);
			pow--;
		}
	    System.out.println(integer);
	    return integer;
	}

	
	/**
	 * Convierte la parte decimal (Fraccionaria) a base diez.
	 * @param string. Parte entera de un número
	 * @param initialBase. Base del número ingresado
	 * @return Parte decimal en base diez.
	 */
	private double convertFloat(String string, int initialBase) {
		int[] digits = parseChar(string.toCharArray());
		double integer = 0;
	    int pow = -1;
	    for (int i = 0; i < digits.length; i++) {
			integer += digits[i]*Math.pow(initialBase, pow);
			pow--;
		}
	    return integer;
	}

	/**
	 * Verifica si el número que ingresa en un punto flotante
	 * @param number. Número a verificar
	 * @return True si es decimal. False si no lo es
	 */
	private boolean validateFloat(String number) {
		char[] digits = number.toCharArray();
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == '.') {
				return true;
			}
		}
		return false;
	}

	/**
	 * Convierte un número de base diez a la base indicada
	 * @param number. Número a convertir
	 * @param finalBase. Base a la que se quiere convertir
	 * @param trunk. Precisión de los decimales
	 * @return Número en la base indicada
	 */
	private String convertDecimalToBase(String number, int finalBase, int trunk) {
		if (validateFloat(number)) {
			String[] aux = number.split("\\.");
			return (convertIntegerToBase(aux[0], finalBase) +"."+ convertFloatToBase(aux[1], finalBase, trunk));
		}else {
			return "" + convertIntegerToBase(number, finalBase);
		}
	}
	
	/**
	 * Convierte la parte entera en base diez a la base indicada
	 * @param string. Número a convertir
	 * @param finalBase. Base a la que se quiere convertir
	 * @return Número entero en base ingresada
	 */
	private String convertIntegerToBase(String string, int finalBase) {
		int waste = 0;
		String integer = "";
		int actual = Integer.parseInt(string);
		while (actual > 0) {
			waste = actual % finalBase;
			integer = parseCharLetter(waste) + integer;
			actual = actual/finalBase;
		}
		return integer;
	}

	/**
	 * * Convierte la parte decimal (Fraccionaria) a la base ingresada.
	 * @param string. Parte entera de un número
	 * @param finalBase. Base a la que se quiere convertir
	 * @param trunk. Precisión de los decimales
	 * @return Parte decimal en base ingresada.
	 */
	private String convertFloatToBase(String string, int finalBase, int trunk) {
		double actual = Double.parseDouble("0."+string);
		String integer = "";
		int count = trunk; 
		while (count > 0) {
			int aux = (int) (actual*finalBase);
			integer = integer + parseCharLetter(aux);
			actual = (actual*finalBase) - (double)aux;
			count--;
			if (actual == 0) {
				return integer.substring(2);
			}
		}
		return integer;
	}

		/**
		 * Convierte un arreglo de char a enteros
		 * @param Arreglo a convertir
		 * @return Arreglo de enteros
		 */
		private int[] parseChar(char[] charArray) {
			int[] aux = new int[charArray.length];
			for (int i = 0; i < charArray.length; i++) {
				aux[i] = parseLetter.get(charArray[i]);
			}
			return aux;
		}
		
		/**
		 * Convierte un número a letra
		 * @param number. Número a convertir
		 * @return Letra que representa el número
		 */
		private String parseCharLetter(int number) {
			return parseNumber.get(number);
		}
}
