package edu.uptc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="enfermedad")
public class Enfermedad {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="nombre")
    private String nombre=new String();
	@Column(name="descripcion")
    private String descripcion = new String();
	@ManyToOne
	private Persona persona;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
