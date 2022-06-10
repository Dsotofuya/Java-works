package Control;

import java.util.ArrayList;
import java.util.List;

import Model.Hardware;

public class HardwareController {

	private List<Hardware> listHardware;
	private Hardware hardware;
	
	public HardwareController() {
		listHardware = new ArrayList<>();
	}
	
	
	
	public void deleteHardware(String id) {
		for (int i = 0; i < listHardware.size(); i++) {
			if (listHardware != null && listHardware.get(i).getId().equals(id)) {
				listHardware.remove(hardware);
			}
		}
	}
	
	public String[] hardwareTable() {
		String[] list = new String[5];
		if (listHardware != null && !listHardware.isEmpty()) {
			for (Hardware hardware : listHardware) {
				list[0] = hardware.getId();
				list[1] = hardware.getName();
				list[2] = hardware.getDescription();
				list[3] = String.valueOf(hardware.getQuantity());
				list[4] = String.valueOf(hardware.getPrice());
 			}
		}
		return list;
	}
	
	
	public static Hardware createHardware(String id, String name, String description, int quantity, double price) {
		return new Hardware(id, name, description, quantity, price);
	}
	public  void addHardware(Hardware hardware) {
		listHardware.add(hardware);
	}
}
