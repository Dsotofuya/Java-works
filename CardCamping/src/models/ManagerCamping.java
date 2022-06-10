package models;

import java.util.ArrayList;

public class ManagerCamping {//DAO(Data Access Object) class
	//the DAO manages the objects lists
	private ArrayList<CampingZone> campingZoneList;
	private ArrayList<Guest> personList;
	
	public ManagerCamping() {//this DAO doesn't needs parameters
		campingZoneList = new ArrayList<>();//allows memory for the list
		personList = new ArrayList<>();
	}

	public static CampingZone createCampingZone(CampingZoneType type, int x, int y){//creates a CZone object with the given parameters
		return new CampingZone(type, x, y);//gives a CZone as output
	}
	
	public void addCampingZone(CampingZone campingZone){//adds a cZone object to this list
		campingZoneList.add(campingZone);//adds created cZone
	}
	
	public ArrayList<CampingZone> getCampingZoneList() {//reads and gets the list
		return campingZoneList;//returns the actualized list
	}
	
	public static Guest createPerson(String name, String photoPath){//creates a person with a name and imgPath
		return new Guest(name, photoPath);//returns Person obj
	}
	
	public void addPerson(Guest person){//receives the Person obj
		personList.add(person);//adds the Person obj to the PList
	}
	
	public ArrayList<Guest> getPersonList() {//reads and gets person list
		return personList;//returns the actualized PList
	}
	
	public void reserve(int id, int hours){//adds a reserve in a available Camp 
		for (CampingZone campingZone : campingZoneList) {//reads all the list applying the conditional
			if (campingZone.getId() == id) {//looks for the object with the given id 
				campingZone.reserve(hours);//when found sets the new hour value 
			}
		}
	}

	public Reserve checkOut(int id, Guest person) throws CampingNotFound {
		for (CampingZone campingZone : campingZoneList) {
			if (campingZone.getId() == id) {
				campingZone.checkOut();
				return new Reserve(campingZone, person, campingZone.getHoursNumber());
			}
		}
		throw new CampingNotFound();
	}
	
	public ArrayList<CampingZone> search(String status, CampingZoneType type){
		ArrayList<CampingZone> report = new ArrayList<>();
		for (CampingZone campingZone : campingZoneList) {
			boolean avalible = status.equals("Libre");
			if ((campingZone.getType().equals(type) || type.equals(CampingZoneType.ALL)) 
					&& (campingZone.isAvailable() == avalible || status.equals("Todos"))) {
				report.add(campingZone);
			}
		}
		return report;
	}
}