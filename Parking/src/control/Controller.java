package control;

import view.*;
import models.LocalParkingResurce;
import models.LocalParking;
import models.WashManager;
import models.ManagerVehicle;

public class Controller {
	private View view;
	private LocalParking localParking;
	private WashManager washManager;
	private ManagerVehicle managerVehicle;
	private LocalParkingResurce localParkingResurce;
	
	public Controller() {
		view = new View();
		localParkingResurce = new LocalParkingResurce();
		washManager = new WashManager();
		managerVehicle = new ManagerVehicle();
		localParking = new LocalParking();
		showGlobalMenu();
		
	}
	
	public void showGlobalMenu() {
		switch (view.getOptionGlobal()){
			case MENU_REGISTER_VEHICLES:
				showMenu();
				break;
			case MENU_RESOURCES:
				resourceMenu();	
				break;
			}showGlobalMenu();
	}
	
	public void showMenu() {
		switch (view.getOption()){
			case REGISTER_PRODUCT:
				addVehicle();
				break;
			case WASH_VEHICLE:
				washVehicle();	
				break;
			case SHOW_AVAILABLE_PLACES:
				showQuotasAvalibles();
				break;
			case TAKE_PARKING_BILL:
				takeParkingBill();
				break;
			case MOTOCYCLES_AT_PARKING:
				getNumberOfBikeAtParcking();
				break;
			case PORCENTAGE_PARKING:
				getPorcentage();
			case BACK_MENU:
				showGlobalMenu();
			}
	}
	
	public void resourceMenu() {
		switch (view.getOptionResource()){
			case AVALIBLE_SOAP:
				getQuantityOfSoap();
				break;
			case WATER_REMAIN:
				getQuantityOfWater();
				break;
			case RENTABLE_TYPE_OF_SERVICE:
				takeMostRentableType();
				break;
			case MONEY_COLLECT:
				getWiningRemains();
				break;
			case BACK_MENU:
				showGlobalMenu();
			}
		showGlobalMenu();
	}

	private void getPorcentage() {
	view.showPorcentageTotal(managerVehicle.getVehiclesParked(),managerVehicle.getNumberCarsWithBothServices());
	}

	public void addVehicle() {
		managerVehicle.addVehicle(managerVehicle.createVehicle(view.getTypeOfVehicle(), view.getPlate()));
		view.getUpdate();
	}	
	
	public void takeParkingBill() {
		view.takeParkingBill(localParkingResurce.takeParkingBill(view.selectVehicle(managerVehicle.getListVehicle())));
	}

	public void washVehicle() {
		if (managerVehicle.washVehicle(view.selectVehicle(managerVehicle.getListVehicle())) == true) {
			view.getUpdate();
		}else {
			view.getIncorrect();
		}
		
	}
	
	public void showQuotasAvalibles() {
		view.getInt(managerVehicle.showQuotasAvalibles());
	}
	
	public void getNumberOfBikeAtParcking() {
		view.getInt(managerVehicle.getNumberOfBikeAtParcking());
	}
	
	public void getQuantityOfSoap() {
		view.showQuantity(localParking.getQuantityOfSoap());
	}
	
	public void getQuantityOfWater() {
		view.showQuantity(localParking.getQuantityOfWater());
	}
	
	public void takeMostRentableType() {
		view.showRecomended(localParkingResurce.getMostRentableType());
	}
	
	public void getWiningRemains() {
		view.showMoneyCollect(localParkingResurce.getMoneyCollect());
	}
	
	public static void main(String[] args) {
		Controller control = new Controller();
	}
}