package models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class Person {

	private int id;
	private static int personCount;
	private String name;
	private Genre genre;
	private Calendar bornDate;

	public Person(String name, Genre genre, Calendar bornDate) {
		this.id = ++personCount;
		this.name = name;
		this.genre = genre;
		this.bornDate = bornDate;
	}
	
	public int getYears() {
		return LocalDate.now().minus(
				Period.of(bornDate.get(Calendar.YEAR),
						bornDate.get(Calendar.MONTH), 
						bornDate.get(Calendar.DAY_OF_MONTH))).getYear(); 
	}
	
	public boolean checkPension() {
		return getYears() > genre.getYearsToPension();
	}
	public boolean checkAgeFilter(int age) {
		return getYears() >= age;
	}

	@Override
	public String toString() {
		return "[" + id + ", " + name + ", " + genre + "]";
	}

	public Genre getGender() {
		return genre;
	}
}