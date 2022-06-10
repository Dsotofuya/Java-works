package Control;

import Reporte.GenericReporte;
import Reporte.TipoReporte;

public class Controller {

	public void generarReporte(TipoReporte reporte) {
			GenericReporte gr = reporte.getInterfaceGenerica();
			gr.generarReporte();	
	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
		 c.generarReporte(TipoReporte.CASA);
		 c.generarReporte(TipoReporte.HABITACION);
		 c.generarReporte(TipoReporte.LOCAL);
	}
}
