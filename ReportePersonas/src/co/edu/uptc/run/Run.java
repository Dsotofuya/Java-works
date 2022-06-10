package co.edu.uptc.run;

import co.edu.uptc.controller.Controlador;
import co.edu.uptc.model.TipoDocumentoEnum;

public class Run {
	
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		controlador.addPersona("Juan Jose", "Gomez Perez", TipoDocumentoEnum.CC, "123434");
		controlador.addPersona("Oscar Ivan", "Zapata Peerea", TipoDocumentoEnum.NIT, "900343245-1");
		controlador.addPersona("Camilo Andres", "Diaz Mendivelso", TipoDocumentoEnum.TI, "5445454");
		controlador.addPersona("Juanita", "Hernandez", TipoDocumentoEnum.CE, "1243557dgfd3232");
		controlador.generarReporte();
	}

}
