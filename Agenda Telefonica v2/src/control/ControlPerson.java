package control;

import java.util.ArrayList;

import logic.Person;

public class ControlPerson {
	private ArrayList<Person> personas;
		
	public ControlPerson(){
		personas = new ArrayList<Person>();
	}
	
	public void addPerson(String nombre, int numero, String ciudad) {
		Person persona = new Person();
		persona.setNombre(nombre);
		persona.setNumero(numero);
		persona.setCiudad(ciudad);
			savePerson(persona);
	}
	
	public void savePerson(Person persona){
		personas.add(persona);
	}
	
	public void showPerson(){
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i));
			personas.toString();
		}
	}
	
	public void deleteThis(int numero){
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getNumero() == 13212432) {
				personas.remove(i);
			}
		}
	}
	
}
