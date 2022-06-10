package models;

public class CampingZone {//blueprint for Camp objects

	private int id;//exclusive id
	private static int count;//static id counter
	private CampingZoneType type;//enumerated type
	private int x;//location x axis
	private int y;//location y axis
	private boolean available;//availability
	private int hoursNumber;//duration
	
	public int getHoursNumber() {//returns duration for reserve class
		return hoursNumber;
	}

	public CampingZone(CampingZoneType type, int x, int y) {//parameters
		this.id = count++;
		this.type = type;
		this.x = x;
		this.y = y;
		this.available = true;//set default boolean state as true
	}
	//there are no setter for HoursNum, nor there are G o S for coordinates
	// x and y will be set randomly
	@Override
	public String toString() {
		return "CampingZone [id=" + id + ", type=" + type + ", x=" + x + ", y="
				+ y + ", available=" + available + "]";
	}

	public int getId() {
		return id;
	}

	public boolean isAvailable() {//flag for availability
		return available;
	}

	public void reserve(int hoursNumber) {//method that receives duration from Reserve and sets availability
		this.hoursNumber = hoursNumber;
		available = false;
	}

	public void checkOut() {//changes availability when checkOut
		available = true;
	}
	
	public CampingZoneType getType() {//returns name from given enumerate list
		return type;
	}
}