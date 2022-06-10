package models;

public class WashManager {
	private ManagerVehicle manageVehicle;
	public WashManager() {
		manageVehicle = new ManagerVehicle();
	}
	
	public double showPorcentageCarWashes(){
		double porcentage;
		int perPark = 0;
		for (int count = 0; count < manageVehicle.getListVehicle().length; count++) {
			if(manageVehicle.getListVehicle()[count] != null){
				if (manageVehicle.getListVehicle()[count].state == StateOfVehicle.PARQUEADOS_Y_LAVADOS) {
				perPark++;
				}
			}
		} porcentage = (perPark*100)/manageVehicle.getListVehicle().length;
		return porcentage;
	}
	
	public int getVehiclesWashes() {
		int vehiclesWashes = 0;
		for (int count = 0; count < manageVehicle.getListVehicle().length; count++) {
			if(manageVehicle.getListVehicle()[count] != null) {
				if (manageVehicle.getListVehicle()[count].state == StateOfVehicle.LAVADO || manageVehicle.getListVehicle()[count].state == StateOfVehicle.PARQUEADOS_Y_LAVADOS) {
				vehiclesWashes++;
				}
			}
		}
		return vehiclesWashes; 
	}

}
