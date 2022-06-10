package Model;

import java.util.ArrayList;
import java.util.List;

public class ManagerHardware {
	
//	Esta clase mantiene el crud
	
	private ArrayList<Hardware> hardwareList;
	private Hardware hardware;
	
	public ManagerHardware() {
		hardwareList = new ArrayList<>();
	}
	
	public static Hardware createHardware(String name, String description, String quantity, String price) {
		return new Hardware(name, description, quantity, price);
	}
	
	public void addHardware(Hardware hardware) {
		hardwareList.add(hardware);
	}
	
	public void deleteHardware(int id) {
		for (int i = 0; i < hardwareList.size(); i++) {
			if (hardwareList != null && hardwareList.get(i).getIdVar() ==id) {
				hardwareList.remove(hardware);
			}
		}
	}

	/* Getters & Setters */
	
	public ArrayList<Hardware> getHardwareList() {
		return hardwareList;
	}

	public void setHardwareList(ArrayList<Hardware> hardwareList) {
		this.hardwareList = hardwareList;
	}

	public Hardware getHardware() {
		return hardware;
	}

	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}
	
	
	
	
}
