package Properties;

public class PropertiesLanguaje extends java.util.Properties{
	private static final long serialVersionUID = 2973327545506692441L;

	public PropertiesLanguaje(String languaje) {
		if (languaje.equals("Espa\u00F1ol")) {
			getProperties("Spanish.properties");
		} else if (languaje.equals("English")) {
			getProperties("English.properties");
		} else if (languaje.equals("Portuguese")) {
			getProperties("Portuguese.properties");
		}
	}

	private void getProperties(String languaje) {
		try {
			load(getClass().getResourceAsStream(languaje));
		} catch (Exception e) {
		}
	}
}
