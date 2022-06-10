package control;

import logic.Person;

public class ControlPerson {
	private Person [] persons;
	private int contador;
	
	public ControlPerson() {
		persons = new Person[3];
		contador = 0;
	}
	
	public void addPersona(String nombre, int numero, String ciudad){
		Person personUno = new Person();
		personUno.setNombre(nombre);
		personUno.setNumero(numero);
		personUno.setCiudad(ciudad);
		
		persons[contador] = personUno;
		
		contador++;
	}
	
	public String [][] createMatriz (){
		String [][] diary = new String [4][3];
		
		for (int i = 0; i < persons.length; i++) {
			diary[i+1][0] = persons[i].getNombre()+"\t";
			diary[i+1][1] = String.valueOf(persons[i].getNumero())+"\t";
			diary[i+1][2] = persons[i].getCiudad();
		}
		
		return diary;
	}
	
	public void viewMatriz(String [][] matriz){
		String [] names = {"Nombre\t","Numero\t\t","Ciudad\t"};
		matriz [0] = names;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}
		
	}
	
}
