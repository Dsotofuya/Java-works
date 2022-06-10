package models;

public class CampingNotFound extends Exception{//exception class

	private static final long serialVersionUID = 1L;

	public CampingNotFound() {
		super("No existe un camping con ese id");//Superclass Exception String parameter
	}
}