package edu.uptc.test;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.uptc.entity.Historiaclinica;
import edu.uptc.entity.Persona;

public class TestInsertarHC {
	private static EntityManager manager;
	private static EntityManagerFactory managerFactory;

	public static void main(String[] args) {
		managerFactory = Persistence.createEntityManagerFactory("JPA_PU");
		manager = managerFactory.createEntityManager();
		Historiaclinica hc = new Historiaclinica();
		hc.setId(1);
		hc.setPersona(new Persona(444, "1002328345", "C", "juan", "topo", Date.valueOf("1999-09-03"), hc));
		manager.getTransaction().begin();
		manager.persist(hc);
		manager.getTransaction().commit();
	}
}
