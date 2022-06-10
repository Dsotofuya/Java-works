package models;

import java.util.Calendar;

public class PersonManager {

	private Person [] personList;
	private static final int MAX_PERSON_IN_LIST = 10;
	
	public PersonManager() {
		personList = new Person[MAX_PERSON_IN_LIST];
	}
	
	public static Person createPerson(String name, Genre genre, Calendar bornDate) {
		return new Person(name, genre, bornDate);
	}
	
	public void addPerson(Person person) {
		for (int i = 0; i < personList.length; i++) {
			if (personList[i] == null) {
				personList[i] = person;
				return;
			}
		}
	}
	
	public Person[] getPersonList() {
		Person [] list = new Person[countPerson()];
		int count = 0;
		for (int i = 0; i < personList.length; i++) {
			if (personList[i] != null) {
				list[count++] = personList[i];
			}
		}
		return list;
	}
	
	private int countPerson() {
		int count = 0;
		for (int i = 0; i < personList.length; i++) {
			if (personList[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	public Person[] getPersonToPensionList() {
		Person [] list = getPersonList();
		Person [] listToPension = new Person[list.length];
		int count = 0;
		for (Person person : list) {
			if (person.checkPension()) {
				listToPension[count++] = person;
			}
		}
		return listToPension;
	}

	public int personsByFilter(int age, Genre genre) {
		int personsActive = 0;
		double count = 0;
		int percentage = 0;
		for (int i = 0; i < personList.length; i++) {
			if(personList[i] != null) {
				personsActive++;
				if(personList[i].getYears() >= age && personList[i].getGender() == genre) {
					count++;
			}
		}
			
		} count = (count / personsActive) * 100; 
		return percentage = (int) (count);
	}
	
	public String filter(int age, Genre genre) {
		int percentage = personsByFilter(age, genre);
		String report = "";
		String report2 = "|";
		for (int i = 0; i < percentage; i= i++) {
		report += report2;	
		}
		return report;
	}
}