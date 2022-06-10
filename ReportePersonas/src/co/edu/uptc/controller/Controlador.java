package co.edu.uptc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.uptc.dto.PersonaDTO;
import co.edu.uptc.model.Persona;
import co.edu.uptc.model.TipoDocumentoEnum;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Controlador {

	private List <Persona> listPersona;

	public Controlador() {
		listPersona = new ArrayList<>();
	}

	public void generarReporte() {
		List<PersonaDTO> listDto = PersonaDTO.convertModelToDto(this.listPersona);
		HashMap<String, Object> params = new HashMap<>();
		params.put("listPersonas", listDto);
		params.put("RUTA", "G:\\Nueva carpeta\\ReportePersonas\\reports\\");
		try {
			JasperDesign jsd = JRXmlLoader.load("G:\\Nueva carpeta\\ReportePersonas\\reports\\reporte.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(jsd);
			JasperPrint jp = JasperFillManager.fillReport(jr, params,  new JREmptyDataSource());
			FileOutputStream output = null;
			try {
				output = new FileOutputStream(new File("D:\\Prueba pdf"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			JasperExportManager.exportReportToPdfStream(jp, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPersona(String nombres, String apellidos, TipoDocumentoEnum tipoDocumento, String numeroDocumento) {
		listPersona.add(new Persona(nombres, apellidos, tipoDocumento, numeroDocumento));
	}

	public List<Persona> getListPersona() {
		return listPersona;
	}

	public void setListPersona(List<Persona> listPersona) {
		this.listPersona = listPersona;
	}

}
