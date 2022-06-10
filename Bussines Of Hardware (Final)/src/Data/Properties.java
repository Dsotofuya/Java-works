package Data;

public class Properties extends java.util.Properties {


	/**
	 * Controla que idioma se va a usar
	 */
	private static final long serialVersionUID = 1L;

	public Properties(String idioma) {
		if (idioma.equals("ESPAÑOL")) {
			getProperties("Español.properties");
		} else if (idioma.equals("INGLES")) {
			getProperties("Ingles.properties");
		} else if (idioma.equals("PORTUGUES")) {
			getProperties("Portugues.properties");
		} else if (idioma.equals("FRANCES")) {
			getProperties("Frances.properties");
		} else if (idioma.equals("CHINO")) {
			getProperties("Chino.properties");
		} 
	}

	private void getProperties(String idioma) {
		try {
			load(getClass().getResourceAsStream(idioma));
		} catch (Exception e) {
		}
	}
}

