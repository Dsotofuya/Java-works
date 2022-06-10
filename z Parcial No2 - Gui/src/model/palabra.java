package model;

public class palabra {
	private String palabra;
	private String traduccionIngles;
	private String traduccionFrances;
	
	public palabra(String palabra, String traduccionIngles, String traduccionFrances) {
		this.palabra = palabra;
		this.traduccionIngles = traduccionIngles;
		this.traduccionFrances = traduccionFrances;
	}
	
	public String getPalabra() {
		return palabra;
	}

	public String getTraduccionIngles() {
		return traduccionIngles;
	}

	public String getTraduccionFrances() {
		return traduccionFrances;
	}

	
	
}
