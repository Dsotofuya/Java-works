package edu.uptc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historiaclinica")
public class Historiaclinica implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private int id;
	@OneToOne	
	private Persona persona;
	
	public Historiaclinica() {
		
	}
	public Historiaclinica(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public void setId(int id) {
		this.id = id;
	}
		
}
