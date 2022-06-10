package model;

public class Calculadora {
		private final int numbDigitos;
		private static String nombre;

		public Calculadora(){
			numbDigitos = 5;
		}

		public static String getNombre() {
			return nombre;
		}

		public static void setNombre(String nombre) {
			Calculadora.nombre = nombre;
		}

		public int getNumbDigitos() {
			return numbDigitos;
		}
}
