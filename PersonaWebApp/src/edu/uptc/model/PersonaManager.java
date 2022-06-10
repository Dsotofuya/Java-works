package edu.uptc.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import edu.uptc.entity.Persona;

public class PersonaManager {
	//@PersistenceContext(unitName="PersonaWebApp")
	private EntityManager em;   
    private EntityManagerFactory emf;
    private Logger log = Logger.getLogger(PersonaManager.class);
    
	public PersonaManager() {
		try {
			emf= Persistence.createEntityManagerFactory("PersonaWebApp");
	    	em=emf.createEntityManager();
		}catch(Exception e) {
    		Writer buffer = new StringWriter();
    		PrintWriter pw = new PrintWriter(buffer);
    		e.printStackTrace(pw);
    		log.info(buffer.toString());
    	}
	}

	public boolean addPersona(Persona persona) {
    	boolean res = false;
    	em.getTransaction().begin();
    	em.persist(persona);
    	em.getTransaction().commit();
    	res=true;
    	return res;
    }
	
	public boolean delPersona(Persona persona) {
    	boolean res = false;
   		em.getTransaction().begin();
   		em.remove(persona);
   		em.getTransaction().commit();
   		res=true;
		return res;
    }
	
	public boolean updatePersona(Persona persona) {
    	boolean res = false;
    	log.info("PErsona doc: "+persona.getDocumento());
   		em.getTransaction().begin();
   		em.merge(persona);
   		em.getTransaction().commit();
   		res=true;
		return res;
    }
	
	public Persona findPersonaPK(String documento) {
		Persona persona = em.find(Persona.class, documento);
   		if (persona == null) {
    		throw new EntityNotFoundException("Can't find Person for ID "+ documento);
   		}
		return persona;
    }
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersona() {
		List<Persona> lista;
		lista = em.createQuery("SELECT e FROM Persona e").getResultList();
		for (Persona p: lista) {
			log.info("Persona_ "+p.getDocumento()+" nom: "+p.getNombres());
		}
		return lista; 
    }
}
