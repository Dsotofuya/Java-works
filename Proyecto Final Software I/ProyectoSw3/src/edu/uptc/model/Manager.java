package edu.uptc.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import edu.uptc.entity.Admin;
import edu.uptc.entity.RealState;
import edu.uptc.entity.RealStateID;
import edu.uptc.entity.Resident;

public class Manager {
	// @PersistenceContext(unitName="PersonaWebApp")
	private EntityManager em;
	private EntityManagerFactory emf;
	private Logger log = Logger.getLogger(Manager.class);

	public Manager() {
		try {
			emf = Persistence.createEntityManagerFactory("ProyectoSw");
			em = emf.createEntityManager();
		} catch (Exception e) {
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
		res = true;
		return res;
	}

	public boolean addState(RealState realState) {
		boolean res = false;
		em.getTransaction().begin();
		em.persist(realState);
		em.getTransaction().commit();
		res = true;
		return res;
	}

	public RealState findRealState(RealStateID realStateID) {
		RealState realState = em.find(RealState.class, realStateID);
		if (realState == null) {
			throw new EntityNotFoundException("Can't find realState for" + realStateID.toString());
		}
		return realState;
	}

	public boolean addResident(Resident resident) {
		boolean res = false;
		em.getTransaction().begin();
		em.persist(resident);
		em.getTransaction().commit();
		res = true;
		return res;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<RealState> fetchRealStates() {
		ArrayList<RealState> lista = (ArrayList)em.createQuery("SELECT s FROM RealState s", RealState.class).getResultList();
		return lista;
	}

	public boolean validUser(String userID, String userPassword) {
		boolean flag = false;
		Admin admin = em.find(Admin.class, userID);
		if(admin != null && admin.getAdmin_password().equals(userPassword)) {
			flag = true;
		}
		return flag;
	}
}
