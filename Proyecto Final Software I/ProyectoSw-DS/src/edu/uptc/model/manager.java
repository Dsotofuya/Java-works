package edu.uptc.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import edu.uptc.entity.Admin;
import edu.uptc.entity.RealState;

public class manager {
		//@PersistenceContext(unitName="PersonaWebApp")
		private EntityManager em;   
	    private EntityManagerFactory emf;
	    private Logger log = Logger.getLogger(manager.class);
	    
		public manager() {
			try {
				emf= Persistence.createEntityManagerFactory("ProyectoSw");
		    	em=emf.createEntityManager();
		    	em.setFlushMode(FlushModeType.AUTO);
			}catch(Exception e) {
	    		Writer buffer = new StringWriter();
	    		PrintWriter pw = new PrintWriter(buffer);
	    		e.printStackTrace(pw);
	    		log.info(buffer.toString());
	    	}
		}

		public boolean addAdmin(Admin admin) {
	    	boolean res = false;
	    	em.getTransaction().begin();
	    	em.persist(admin);
	    	em.getTransaction().commit();
	    	res=true;
	    	return res;
	    }

		public boolean addState(RealState realState) {
			boolean res = false;
	    	em.getTransaction().begin();
	    	em.persist(realState);
	    	em.getTransaction().commit();
	    	em.flush();
	    	res=true;
	    	return res;
		}
}
