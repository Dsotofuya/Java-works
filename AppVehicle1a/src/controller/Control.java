package controller;

import view.IoManager;

import java.text.DecimalFormat;

import exceptions.DataValidatorException;
import model.*;

public class Control {
	private IoManager io;
	private Vehicle vehicle;
	private Person owner;
	
	public Control(){
		io = new IoManager();
	}
	public void menu(){
		
		int op=0;
		do{
			try{
				op = io.readMenu();
				switch (op){
					case 1: createVehicle();
							break;
					case 2: createPerson(); 
							break;
					case 3: io.showMessage(vehicle.toString());
							break;
					case 4: subMenu();
							break;	
					case 5: incrementVehicleValue();
							break;	
					case 6: decrementVehicleValue();
					case 7: break;
					default: io.showErrorMessage("Opcion incorrecta");
				}
			}catch (NumberFormatException e){
				io.showErrorMessage("Debe ingresar un valor numerico");
			}catch (DataValidatorException e){
				io.showErrorMessage(e.getMessage());
			}

		}while (op != 7);
	}
	public void subMenu() throws NumberFormatException{
		int op;
		do{
			op = io.readSubMenu();
			switch (op){
				case 1: modifyBrand();
						break;
				case 2: modifyReference(); 
						break;
				case 3: modifyModel();
						break;
				case 4: modifyLicensePlate();
						break;	
				case 5: modifyValue();
						break;	
				case 6: modifyDocIdOwner();
						break;
				case 7: modifyFirstNameOwner();
						break;
				case 8: modifyLastNameOwner();
						break;
				case 9: break;
				default: io.showErrorMessage("Opcion incorrecta");
			}
			
		}while (op != 9);	
		
	}
	public void createVehicle() throws DataValidatorException{
		String brand = io.readString("Marca");
		String reference = io.readString("Referencia");
		int model = io.readInt("Modelo");
		if (model < 1930 || model > 2017){
			throw new DataValidatorException("El modelo debe estar entre 1930 y 2017");
		}
		String licensePlate = io.readString("Placa");
		double value = io.readDouble("Valor");
		vehicle = new Vehicle(brand, reference, model, licensePlate, value);
		io.showMessage("El vehiculo fue creado");
	}
	
	public void createPerson(){
		int docId = io.readInt("Numero Documento de identidad");
		String firstName = io.readString("Nombre");
		String lastName = io.readString("Apellido");
		owner = new Person(docId,firstName,lastName);
		vehicle.setOwner(owner);
		io.showMessage("El propietario fue creado");
	}
	
	public void printVehicle(Vehicle vehicle){
		io.showMessage(vehicle.toString());
	}

	public void incrementVehicleValue(){
		double percentage = io.readDouble("Ingrese % de incremento");
		vehicle.incrementValue(percentage);
		io.showMessage("El valor del vehiculo fue incrementado");
	}
	public void decrementVehicleValue(){
		vehicle.decrementValue();
		io.showMessage("El valor del vehiculo fue disminuido");
	}
	
	public void modifyBrand(){
		String newBrand = io.readString("La marca es " + vehicle.getBrand() + 
				"\n Ingrese nueva marca");
		vehicle.setBrand(newBrand);
		io.showMessage("La marca del vehiculo fue modificada");
	}
	
	public void modifyReference(){
		String newReference = io.readString("La referencia es " + vehicle.getReference() + 
				"\n Ingrese nueva referencia");
		vehicle.setReference(newReference);
		io.showMessage("La referencia del vehiculo fue modificada");
	}
	
	public void modifyModel(){
		int newModel = io.readInt("El modelo es " + vehicle.getModel() + 
				"\n Ingrese nuevo modelo");
		vehicle.setModel(newModel);
		io.showMessage("El modelo del vehiculo fue modificado");
	}

	public void modifyLicensePlate(){
		String newLicensePlate = io.readString("La placa es " + vehicle.getLicensePlate() + 
				"\n Ingrese nueva placa");
		vehicle.setReference(newLicensePlate);
		io.showMessage("La placa del vehiculo fue modificada");
	}
	public void modifyValue(){
		double newValue = io.readInt("El valor es " + vehicle.getValue() + 
				"\n Ingrese nuevo valor");
		vehicle.setValue(newValue);
		io.showMessage("El valor del vehiculo fue modificado");
	}
	
	public void modifyDocIdOwner(){
		int newDocId = io.readInt("El documento del propietario es " + vehicle.getOwner().getDocId() + 
				"\n Ingrese nuevo Doc Id.");
		vehicle.getOwner().setDocId(newDocId);
		io.showMessage("El documento de Id. del propietario fue modificado");
	}
	
	public void modifyFirstNameOwner(){
		String newFirstName = io.readString("El nombre del propietario es " + 
				vehicle.getOwner().getFirstName() + 
				"\n Ingrese nuevo nombre");
		vehicle.getOwner().setFirstName(newFirstName);
		io.showMessage("El nombre del propietario fue modificado");
	}
	
	public void modifyLastNameOwner(){
		String newLastName = io.readString("El apellido del propietario es " +
				vehicle.getOwner().getLastName() + 
				"\n Ingrese nuevo apellido");
		vehicle.getOwner().setLastName(newLastName);
		io.showMessage("El apellido del propietario fue modificado");
	}

}

