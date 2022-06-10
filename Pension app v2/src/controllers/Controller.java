package controllers;

import java.text.ParseException;

import models.PersonManager;
import views.Window;

public class Controller {

	private PersonManager personManager;
	private Window window;
	
	public Controller() {
		personManager = new PersonManager();
		window = new Window();
		init();
	}

	private void init() {
		switch (window.getAction()) {
		case ADD_PERSON:
			addPerson();
			break;
		case SHOW_PERSON_lIST:
			showPersonList();
			break;
		case SHOW_FILTER:
			showFilter();
			break;
		default:
			break;
		}
		init();
	}
	
	private void showFilter() {
		window.showPersonsByFilter(personManager.filter(window.getAge(), window.getGenre()));
	}

	private void addPerson() {
		try {
			personManager.addPerson(PersonManager.createPerson(
					window.getName(), window.getGenre(), window.getBornDate()));
		} catch (ParseException e) {
			e.printStackTrace();
			window.showDateError();
		}
	}

	private void showPersonList() {
		window.showPersonList(personManager.getPersonList());
	}
}