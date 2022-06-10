package models;

public class Reserve {//class that links the cZone and Person, used for create invoices

	private CampingZone campingZone;//Instantiates cZone 
	private Guest person;
	private int hourNumber;//attribute for the duration of a reserve
	public static final int HOUR_VALUE = 15000;//price of the reserve
	
	public Reserve(CampingZone campingZone, Guest person, int hourNumber) {//sets object parameters
		this.campingZone = campingZone;
		this.person = person;
		this.hourNumber = hourNumber;
	}

	public int getValue(){//calculates the reserve value
		return HOUR_VALUE * hourNumber;
	}

	public int getHourNumber() {//gives hour number when executed
		return hourNumber;
	}

	public CampingZone getCamingZone() {//returns the object info
		return campingZone;
	}
	
	public Guest getPerson() {//does the same shit that the last one does
		return person;
	}

}