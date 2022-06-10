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

import edu.uptc.entity.Admin;
import edu.uptc.entity.Bill;
import edu.uptc.entity.Resident;

public class manager {
	private EntityManager em;
	private EntityManagerFactory emf;
	private Logger log = Logger.getLogger(manager.class);

	public manager() {
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

	public boolean addResident(Resident resident) {
		boolean res = false;
		em.getTransaction().begin();
		em.persist(resident);
		em.getTransaction().commit();
		res = true;
		return res;
	}

	public boolean addAdmin(Admin admin) {
		boolean res = false;
		em.getTransaction().begin();
		em.persist(admin);
		em.getTransaction().commit();
		res = true;
		return res;
	}

	public boolean updateResident(Resident resident) {
		boolean res = false;
		em.getTransaction().begin();
		em.merge(resident);
		em.getTransaction().commit();
		res = true;
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Resident> findAllResidents() {
		List<Resident> residents;
		residents = em.createQuery("SELECT r.resident_id FROM Resident r").getResultList();
		for (Resident resident: residents) {
			log.info("Resident: " + resident.getResident_id() +" "+ resident.getResident_name() +" "+ resident.getResident_last_name());
		}
		return residents; 
	}

	public Bill findBill(String billID) {
		Bill bill = em.find(Bill.class, billID);
		if (bill == null) {
			throw new EntityNotFoundException("Can't find bill for ID " + billID);
		}
		return bill;
	}
	

//	@SuppressWarnings("unchecked")
//	public ArrayList<Detail> getDetails(String billId){
//		Query nativeQuery = em.createNativeQuery("SELECT id, name, email FROM user ORDER BY email DESC");
//		List<Detail> results = nativeQuery.getResultList();
//		return results.stream().map(result -> new Detail() );
////	            .stream()
////	            .map(result -> new User(((BigInteger) result[0]).longValue(), (String) result[1], (String) result[2]))
////	            .collect(Collectors.toList());
//		
}

//	public Persona findPersonaPK(String documento) {
//		Persona persona = em.find(Persona.class, documento);
//   		if (persona == null) {
//    		throw new EntityNotFoundException("Can't find Person for ID "+ documento);
//   		}
//		return persona;
//    }
//	@SuppressWarnings("unchecked")
//	public List<Persona> findAllPersona() {
//		List<Persona> lista;
//		lista = em.createQuery("SELECT e FROM Persona e").getResultList();
//		for (Persona p: lista) {
//			log.info("Persona_ "+p.getDocumento()+" nom: "+p.getNombres());
//		}
//		return lista; 
//    }

//
//	public boolean addState(RealState realState) {
//		boolean res = false;
//		em.getTransaction().begin();
//		em.persist(realState);
//		em.getTransaction().commit();
//		res = true;
//		return res;
//	}
//
//	public boolean addResident(Resident resident) {
//		boolean res = false;
//		em.getTransaction().begin();
//		em.persist(resident);
//		em.getTransaction().commit();
//		res = true;
//		return res;
//	}
//}
