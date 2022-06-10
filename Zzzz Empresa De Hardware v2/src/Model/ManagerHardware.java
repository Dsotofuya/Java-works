package Model;

import java.util.ArrayList;
import java.util.List;

public class ManagerHardware {
	
//	Esta clase mantiene el crud
	
	private List<Hardware> hardwareList;
	
	public ManagerHardware() {
		hardwareList = new ArrayList<>();
	}
	
	public static Hardware createHardware(String id, String name, String description, String quantity, String price) {
		return new Hardware(id, name, description, quantity, price);
	}
	
	public void addHardware(Hardware hardware) {
		hardwareList.add(hardware);
	}
	
	public List<Hardware> getHardwareList(){
		return hardwareList;
	}
}
