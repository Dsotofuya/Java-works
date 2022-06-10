package models;

public class LocalParking {
	private static int MAX_SIZE_LOCAL = 10;
	private static double PRICE_PARK_WASH = 15500;
	private static double PRICE_PARK = 2500;
	private static int SOAP_PER_WASH = 2;
	private static double WATER_PER_WASH = 40.5;
	private double moneyCollect;
	private static int FLAVORING_PER_WASH = 1;
	private double quantityOfSoap = 100;
	private double quantityOfWater = 7456.521;
	private int quantityOfFlavorings = 125;
	private Vehicle [] historyVehicles;
	
	public LocalParking() {
		historyVehicles = new Vehicle[MAX_SIZE_LOCAL];
	}
	
	public double getQuantityOfSoap() {
		return quantityOfSoap;
	}

	public void setQuantityOfSoap(double quantityOfSoap) {
		this.quantityOfSoap = quantityOfSoap;
		
	}

	public double getQuantityOfWater() {
			return quantityOfWater;
	}

	public void setQuantityOfWater(double quantityOfWater) {
		this.quantityOfWater = quantityOfWater;
	}

	public int getQuantityOfFlavorings() {
		return quantityOfFlavorings;
	}

	public void setQuantityOfFlavorings(int quantityOfFlavorings) {
		this.quantityOfFlavorings = quantityOfFlavorings;
	}

	public static int getFLAVORING_PER_WASH() {
		return FLAVORING_PER_WASH;
	}

	public Vehicle[] getHistoryVehicles() {
		return historyVehicles;
	}

	public  static double getPRICE_PARK_WASH() {
		return PRICE_PARK_WASH;
	}

	public static int getSOAP_PER_WASH() {
		return SOAP_PER_WASH;
	}

	public static double getPRICE_PARK() {
		return PRICE_PARK;
	}

	public  static double getWATER_PER_WASH() {
		return WATER_PER_WASH;
	}
	
	public static int getMAX_SIZE_LOCAL() {
		return MAX_SIZE_LOCAL;
	}
	
	public double getMoneyCollect() {
		return moneyCollect;
	}
	
	public void setMoneyCollect(double moneyCollect) {
		this.moneyCollect = moneyCollect;
	}
}