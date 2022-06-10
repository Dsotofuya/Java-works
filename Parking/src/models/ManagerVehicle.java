package models;

public class ManagerVehicle {
	private Vehicle[] listVehicle;
	private LocalParking localParking;
	
	public ManagerVehicle() {
		listVehicle = new Vehicle[localParking.getMAX_SIZE_LOCAL()];
		localParking = new LocalParking();
	}
	
	public Vehicle[] getListVehicle() {
		return listVehicle;
	}
	
	public Vehicle createVehicle(TypeOfVehicle type, String plate) {
		Vehicle vehicle;
		if (type == TypeOfVehicle.GRANDE || type == TypeOfVehicle.PEQUEÑO) {
			vehicle = new Car(type, plate, StateOfVehicle.PARQUEADO);
			return vehicle;
		}else
			vehicle = new Motorcycle(type, plate, StateOfVehicle.PARQUEADO);
			return vehicle;
	}
	
	public Vehicle createVehicleHistory(TypeOfVehicle type, String plate, StateOfVehicle state) {
		Vehicle vehicle;
		if (type == TypeOfVehicle.GRANDE || type == TypeOfVehicle.PEQUEÑO) {
			vehicle = new Car(type, plate, state);
			return vehicle;
		}else
			vehicle = new Motorcycle(type, plate, state);
			return vehicle;
	}
	
	public void addVehicleHistory(Vehicle newVehicle){
		for (int count = 0; count < listVehicle.length; count++) {
			if (localParking.getHistoryVehicles()[count] == null) {
				localParking.getHistoryVehicles()[count] = newVehicle;
				return;
			}
		}
	}
	
	public void addVehicle(Vehicle newVehicle){
		for (int count = 0; count < listVehicle.length; count++) {
			if (listVehicle[count] == null) {
				listVehicle[count] = newVehicle;
				return;
			}
		}
	}

	public int getVehiclesParked() {
		int vehiclesParked = 0;
		int perPark = 0;
		for (int count = 0; count < listVehicle.length; count++) {
			if(listVehicle[count]!= null) {
				if (listVehicle[count].state == StateOfVehicle.PARQUEADO) {
					perPark++;
				}
			}
		}vehiclesParked = (perPark*100)/ listVehicle.length;
		return vehiclesParked; 
	}
	
	public int getNumberOfBikeAtParcking() {
			int motorcycle = 0;
			for (int count = 0; count < listVehicle.length; count++) {
				if(listVehicle[count] != null) {
				if (listVehicle[count].type == TypeOfVehicle.ALTO_CILINDAJE || listVehicle[count].type == TypeOfVehicle.REGULAR) {
					motorcycle++;
				}
				}
			}
			return motorcycle; 
		}
	
	public int showQuotasAvalibles(){
		int quotas = 0;
		for (int count = 0; count < listVehicle.length; count++) {
			if(listVehicle[count] != null) {
				if (listVehicle[count].state == StateOfVehicle.PARQUEADO || listVehicle[count].state == StateOfVehicle.PARQUEADOS_Y_LAVADOS) {
					quotas++;
				}
			} 
		}return quotas = listVehicle.length - quotas;
	}

	public void removeFromLocalVehicle(String plate) {
		  for (int i = 0; i < listVehicle.length; i++) {
	            if (listVehicle[i] != null) {
		            if(listVehicle[i].plate.equalsIgnoreCase(plate)) {
	            	addVehicleHistory(createVehicleHistory(listVehicle[i].type , listVehicle[i].plate, listVehicle[i].state));
	            	listVehicle[i] = null;
	            	}
	            }
	        }
	}

	public Boolean washVehicle(Vehicle vehicle) {
		Boolean efect = null;
		double soap = localParking.getQuantityOfSoap();
		double soapMinimum = (localParking.getSOAP_PER_WASH() * 2);
		if(soap > soapMinimum) {
			if (vehicle.type == TypeOfVehicle.GRANDE || vehicle.type == TypeOfVehicle.PEQUEÑO) {
				if (vehicle instanceof Car) {
					Car car = (Car) vehicle;
					car.wash();
					localParking.setQuantityOfSoap(soap - localParking.getSOAP_PER_WASH()); 
					localParking.setQuantityOfWater(localParking.getQuantityOfWater() - localParking.getWATER_PER_WASH());
					localParking.setQuantityOfFlavorings(localParking.getQuantityOfFlavorings() - localParking.getFLAVORING_PER_WASH());
				}efect = true;
				
			} else {
				efect = false;
			}
		}
		return efect;
		}

	public int getNumberCarsWithBothServices() {
		int carsParkedAndWashes = 0;
		int perPark = 0;
		for (int count = 0; count < listVehicle.length; count++) {
			if(listVehicle[count]!= null) {
				if (listVehicle[count].state == StateOfVehicle.PARQUEADOS_Y_LAVADOS) {
					perPark++;
				}
			}
		}carsParkedAndWashes = (perPark*100)/listVehicle.length;
		return carsParkedAndWashes; 
	}
}