package model;

import java.util.ArrayList;

public class VehicleTax {

	private ArrayList<Brand> brandList;
	
	public VehicleTax(ArrayList<Brand> brandList) {
		this.brandList = brandList;
	}
	
	
	
	public double find(String brandFinded, String lineFinded, int modelFinded) {
		double value = 0;
		for (Brand brand : brandList) {
			if(brand.getBrand().equalsIgnoreCase(brandFinded)) {
				ArrayList<Line>	lineList = brand.getLineList();
				for (Line line : lineList) {
					if (line.getLine().equalsIgnoreCase(lineFinded)) {
						ArrayList<Model> modelList = line.getModelList();
						for (Model model : modelList) {
							if (model.getModel() == modelFinded) {
								value = model.getValue();
							}
						}
					}
				}
			}
		}
		return value;
	}
	
	
	public double valueParcialTax(double value) {
		double parcialTax = 0; 
		if (value >= 0 && value <= 30000000) {
			parcialTax = (value * 0.015);
		} if(value > 30000000 && value <= 70000000 ) {
			parcialTax = (value * 0.02);
		} if(value > 70000000 ) {
			parcialTax = (value * 0.025);
		}
		return parcialTax;
	}
	
	public double calculateTax(String brandFinded, String lineFinded, int modelFinded, 
			boolean discountQuickly, boolean discountPublicVehicle, boolean dicountPerPlace) {
			double tax = valueParcialTax(find(brandFinded, lineFinded, modelFinded));
			double finalTax = 0;
			double taxDiscount = 0;
			double aux = 0;
			if(discountQuickly != true && discountPublicVehicle  //Todas son falsas
					!= true && dicountPerPlace != true) {
				finalTax = tax;
			}else if (discountQuickly != false && discountPublicVehicle // Primera verdadera
					!= true && dicountPerPlace != true) {
					finalTax= discountQuickly(tax);
			}else if (discountQuickly != false && discountPublicVehicle //Primera y segunda verdadera
					!= false && dicountPerPlace != true) {
					taxDiscount = discountQuickly(tax);
					finalTax = discountPublicVehicle(taxDiscount);
			}else if (discountQuickly != false && discountPublicVehicle //primera y tercera verdaderas
					!= true && dicountPerPlace != false) {
					taxDiscount = discountQuickly(tax);
					finalTax = discountPerPlace(taxDiscount);
			}else if (discountQuickly != true && discountPublicVehicle // Segunda verdadera
					!= false && dicountPerPlace != true) {
					finalTax = discountPublicVehicle(tax);
			}else if (discountQuickly != true && discountPublicVehicle // segunda y tercera verdadera
					!= false && dicountPerPlace != false) {
					taxDiscount = discountPublicVehicle(tax);
					finalTax = discountPerPlace(taxDiscount);
			}else if (discountQuickly != true && discountPublicVehicle  // tercera verdadera
					!= true && dicountPerPlace != false) {
					finalTax = discountPerPlace(tax);
			}else if (discountQuickly != false && discountPublicVehicle  // todas verdaderas
			!= false && dicountPerPlace != false) {
			aux = discountQuickly(tax);
			taxDiscount = discountPublicVehicle(aux);
			finalTax = discountPerPlace(taxDiscount);
			}return finalTax;
	}

	
	public double discountQuickly(double parcialTax) {
		return parcialTax - (parcialTax * 0.1);
	}
	
	public double discountPublicVehicle(double parcialTax) {
		return parcialTax - 50000;  
	}

	public double discountPerPlace(double parcialTax) {
		return parcialTax - (parcialTax * 0.2);
		
	}
	
	
	public void addBrand(String brand) {
		
	}
	
	public double calculateTaxTest(boolean discountQuickly, boolean discountPublicVehicle, boolean dicountPerPlace, int value) {
			double tax = valueParcialTax(value);
			double finalTax = 0;
			double taxDiscount = 0;
			double aux = 0;
			if(discountQuickly != true && discountPublicVehicle  //Todas son falsas
					!= true && dicountPerPlace != true) {
				finalTax = tax;
				
			}else if (discountQuickly != false && discountPublicVehicle // Primera verdadera
					!= true && dicountPerPlace != true) {
					finalTax= discountQuickly(tax);
			}else if (discountQuickly != false && discountPublicVehicle //Primera y segunda verdadera
					!= false && dicountPerPlace != true) {
					taxDiscount = discountQuickly(tax);
					finalTax = discountPublicVehicle(taxDiscount);
			}else if (discountQuickly != false && discountPublicVehicle //primera y tercera verdaderas
					!= true && dicountPerPlace != false) {
					taxDiscount = discountQuickly(tax);
					finalTax = discountPerPlace(taxDiscount);
			}else if (discountQuickly != true && discountPublicVehicle // Segunda verdadera
					!= false && dicountPerPlace != true) {
					finalTax = discountPublicVehicle(tax);
			}else if (discountQuickly != true && discountPublicVehicle // segunda y tercera verdadera
					!= false && dicountPerPlace != false) {
					taxDiscount = discountPublicVehicle(tax);
					finalTax = discountPerPlace(taxDiscount);
			}else if (discountQuickly != true && discountPublicVehicle  // tercera verdadera
					!= true && dicountPerPlace != false) {
					finalTax = discountPerPlace(tax);
			}else if (discountQuickly != false && discountPublicVehicle  // todas verdaderas
			!= false && dicountPerPlace != false) {
			aux = discountQuickly(tax);
			taxDiscount = discountPublicVehicle(aux);
			finalTax = discountPerPlace(taxDiscount);
			}return finalTax;
	}
	
	
}
