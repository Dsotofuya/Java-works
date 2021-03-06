package edu.uptc.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.EnumSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import edu.uptc.entity.AccountStateType;
import edu.uptc.entity.Admin;
import edu.uptc.entity.RealState;
import edu.uptc.entity.RealStateID;
import edu.uptc.entity.Reservation;
import edu.uptc.entity.Resident;

public class Manager {
	// @PersistenceContext(unitName="PersonaWebApp")
	private EntityManager em;
	private EntityManagerFactory emf;
	private Logger log = Logger.getLogger(Manager.class);

	public Manager() {
		try {
			emf = Persistence.createEntityManagerFactory("ProyectoSoftware");
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

	public boolean addResident(Resident resident, RealState realState) {
		boolean res = false;
		em.getTransaction().begin();
		em.persist(resident);
		em.getTransaction().commit();
		updateRealState(realState);
		res = true;
		return res;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<RealState> fetchRealStates() {
		ArrayList<RealState> lista = (ArrayList) em
				.createQuery("SELECT s FROM RealState s \r\n" + "WHERE s.resident IS NULL", RealState.class)
				.getResultList();
		return lista;
	}

	public boolean validUser(String userID, String userPassword) {
		boolean flag = false;
		Admin admin = em.find(Admin.class, userID);
		if (admin != null && admin.getAdmin_password().equals(userPassword)) {
			flag = true;
		}
		return flag;
	}

	public boolean updateRealState(RealState realState) {
		boolean res = false;
		em.getTransaction().begin();
		em.merge(realState);
		em.getTransaction().commit();
		res = true;
		return res;
	}

	public Resident findResident(String residentId) {
		Resident resident = em.find(Resident.class, residentId);
		if (resident == null) {
			throw new EntityNotFoundException("Can't find resident for" + residentId.toString());
		}
		return resident;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Resident> fetchResidents() {
		ArrayList<Resident> lista = (ArrayList) em.createQuery("SELECT s FROM Resident s", Resident.class)
				.getResultList();
		log.info("listado: ");
		for (Resident resident : lista) {
			log.info(resident.getResident_id() + resident.getResident_name() + resident.getResident_last_name());
		}
		return lista;
	}

	public ArrayList<AccountStateType> fetchStateAccounts() {
		ArrayList<AccountStateType> list = new ArrayList<AccountStateType>(EnumSet.allOf(AccountStateType.class));
		list.remove(AccountStateType.CREADA);
		return list;
	}

	public boolean updateResident(Resident resident) {
		boolean res = false;
		em.getTransaction().begin();
		em.merge(resident);
		em.getTransaction().commit();
		res = true;
		return res;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<RealState> fetchCommunityPlaces() {
		ArrayList<RealState> list = (ArrayList) em
				.createQuery("SELECT rs FROM RealState rs  WHERE rs.realStateType = 2 OR rs.realStateType = 3 ",
						RealState.class)
				.getResultList();
		log.info("list of community places: ");
		for (RealState realState : list) {
			log.info(realState.getRealStateID().toString() + " " + realState.getRealStateEnum().toString());
		}
		return list;
	}

	public boolean addReservation(Reservation reservation) {
		boolean res = false;
		em.getTransaction().begin();
		em.persist(reservation);
		em.getTransaction().commit();
		res = true;
		return res;
	}
}
