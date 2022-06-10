package models;

public enum Genre {
	FEMALE("Mujer", 57), MALE("Hombre", 62);
	private final String text;
	private final int yearsToPension;
	
	private Genre(String text, int yearsToPension) {
		this.text = text;
		this.yearsToPension = yearsToPension;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
	public int getYearsToPension() {
		return yearsToPension;
	}
}