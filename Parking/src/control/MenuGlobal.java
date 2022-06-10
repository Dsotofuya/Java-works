package control;

public enum MenuGlobal {
	MENU_REGISTER_VEHICLES("Menú de registros"), MENU_RESOURCES("Menú de recursos");
	
	private String text;
	
	private MenuGlobal(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}