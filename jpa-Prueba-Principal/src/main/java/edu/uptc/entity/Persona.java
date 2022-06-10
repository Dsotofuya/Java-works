package edu.uptc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {
	
	private static final long serialVersionUID=1L;
	@Id
	@Column(name="documento")
	private String documento;
	@Column(name="tipo_documento")
	private String tipo_documento;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
	@OneToOne(mappedBy="persona", cascade = CascadeType.ALL)
	@JoinColumn(name = "persona_documento", referencedColumnName = "documento")
	private Historiaclinica historiaclinica;

	public Persona(){
		
	}

	public Persona(int id, String documento, String tipo_documento, String nombres, String apellidos,
			Date fecha_nacimiento, Historiaclinica historiaclinica) {
			this.documento = documento;
			this.tipo_documento = tipo_documento;
			this.nombres = nombres;
			this.apellidos = apellidos;
			this.fecha_nacimiento = fecha_nacimiento;
			this.historiaclinica = historiaclinica;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	
	public Historiaclinica getHistoriaclinica() {
		return historiaclinica;
	}

	public void setHistoriaclinica(Historiaclinica historiaclinica) {
		this.historiaclinica = historiaclinica;
	}
}
