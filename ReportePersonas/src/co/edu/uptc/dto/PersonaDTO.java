package co.edu.uptc.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Persona;

public class PersonaDTO {

	private java.lang.String nombres;
	private java.lang.String apellidos;
	private java.lang.String tipoDocumento;
	private java.lang.String numeroDocumento;
	
	public PersonaDTO() {
	}
	
	public static PersonaDTO convertModelToDto(Persona persona){
		PersonaDTO dto = new PersonaDTO();
		dto.setNombres(persona.getNombres());
		dto.setApellidos(persona.getApellidos());
		dto.setNumeroDocumento(persona.getNumeroDocumento());
		dto.setTipoDocumento(persona.getTipoDocumento().toString());
		return dto;
	}
	
	public static List<PersonaDTO> convertModelToDto(List<Persona> personas){
		List<PersonaDTO> list = new ArrayList<>();
		if(personas!=null && !personas.isEmpty()) {
			for (Persona persona : personas) {
				list.add(convertModelToDto(persona));
			}
		}
		return list;
	}

	public java.lang.String getNombres() {
		return nombres;
	}

	public java.lang.String getApellidos() {
		return apellidos;
	}

	public java.lang.String getTipoDocumento() {
		return tipoDocumento;
	}

	public java.lang.String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNombres(java.lang.String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(java.lang.String apellidos) {
		this.apellidos = apellidos;
	}

	public void setTipoDocumento(java.lang.String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setNumeroDocumento(java.lang.String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	
	
}
