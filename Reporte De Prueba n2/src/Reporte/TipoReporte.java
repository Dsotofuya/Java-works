package Reporte;

public enum TipoReporte {
	CASA(new CasaReporte()), HABITACION(new HabitacionReporte()), LOCAL(new LocalReporte());
	
	private GenericReporte interfaceGenerica;
	
	private TipoReporte(GenericReporte iGeneric) {
		this.interfaceGenerica = iGeneric;
	}

	public GenericReporte getInterfaceGenerica() {
		return interfaceGenerica;
	}

	public void setInterfaceGenerica(GenericReporte interfaceGenerica) {
		this.interfaceGenerica = interfaceGenerica;
	}	
	
}
