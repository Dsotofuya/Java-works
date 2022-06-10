package edu.uptc.test;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import edu.uptc.entity.Historiaclinica;
import edu.uptc.entity.Persona;

public class TestCrearPersona {
	
	private static EntityManager em;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("JPA_PU");
		em = emf.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		Persona persona = new Persona();
		persona.setDocumento("112");
		persona.setTipo_documento("C");
		persona.setNombres("pedro");
		persona.setApellidos("pedro2");
		Date fecha_nacimiento = Date.valueOf("2001-03-31");
		persona.setFecha_nacimiento(fecha_nacimiento);
		Historiaclinica hc = new Historiaclinica();
		hc.setId(4);
		hc.setPersona(persona);
		persona.setHistoriaclinica(hc);
		em.getTransaction().begin();
		em.persist(persona);
		em.getTransaction().commit();
	}

}