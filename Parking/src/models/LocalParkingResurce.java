package models;

public class LocalParkingResurce {
	private int laundry;
	private double money;
	private ManagerVehicle manageVehicle;
	private WashManager washManager;
	private LocalParking localParking;
	public LocalParkingResurce() {
		localParking = new LocalParking();
		washManager = new WashManager();
		manageVehicle = new ManagerVehicle();
	}
	
	public double getMoneyCollect(){
		localParking.setMoneyCollect(money);
		return localParking.getMoneyCollect();
	}
	
	public StateOfVehicle getMostRentableType() {
		StateOfVehicle recomended = null;
		double numberParked = manageVehicle.getVehiclesParked();
		double numberWashes = washManager.getVehiclesWashes();
		double numberBothServices = manageVehicle.getNumberCarsWithBothServices();
		if (numberParked >= numberWashes && numberParked >= numberBothServices ){
			recomended = StateOfVehicle.PARQUEADO;
			}else 
				if(numberWashes >= numberParked && numberWashes >= numberBothServices ) {
					recomended = StateOfVehicle.LAVADO;
				}else 
					recomended = StateOfVehicle.PARQUEADOS_Y_LAVADOS;
				
			
		return recomended;
	}
	
	public double takeParkingBill(Vehicle vehicle) {
		double parkingBill = 0;
			if (vehicle.state == StateOfVehicle.PARQUEADO) {
				parkingBill = localParking.getPRICE_PARK();
				manageVehicle.removeFromLocalVehicle(vehicle.plate);
				money += parkingBill;
		}else if(vehicle.state == StateOfVehicle.PARQUEADOS_Y_LAVADOS){
				parkingBill = localParking.getPRICE_PARK_WASH();
				manageVehicle.removeFromLocalVehicle(vehicle.plate);
				money += parkingBill;
		}
		return parkingBill;
		}
}