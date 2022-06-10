package Model.Dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.Hardware;

public class DaoHardware {

	public DaoHardware() {
	}
	
	public ArrayList<Hardware> readArchive(){
		ArrayList<Hardware> list = new ArrayList<>();
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("src\\Data\\Text.json"));
			JSONObject jsonObject = (JSONObject) obj;
			String name = (String) jsonObject.get("name");
			String description = (String) jsonObject.get("description");
			String quantity = (String) jsonObject.get("quantity");
			String price = (String) jsonObject.get("price");
			
			Hardware hardware = new Hardware(name, description, quantity, price);
			list.add(hardware);
		} catch (Exception e) {
			
		}
		return list;
		
	}

	public void saveHardwareList(ArrayList<Hardware> hardwares) {
		JSONObject 	jsonObject = new JSONObject();
		
		if (hardwares != null && !hardwares.isEmpty()) {
		try (FileWriter file = new FileWriter("src\\data\\hardwarelist.json")){
			
		for (Hardware hardware : hardwares) {
			jsonObject.put("name", hardware.getName());
			jsonObject.put("description", hardware.getDescription());
			jsonObject.put("quantity", hardware.getQuantity());
			jsonObject.put("price", hardware.getPrice());
			file.write(jsonObject.toJSONString());
			file.flush();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}
