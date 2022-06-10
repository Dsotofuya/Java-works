package edu.uptc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enfermedad")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 2764431255038365311L;
	@Id
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String name;
	@Column(name="descripci\u00F3n")
	private int description;

	public Enfermedad(int id, String name, int description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Enfermedad() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}
}
