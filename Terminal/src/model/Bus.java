package model;

public class Bus {

	private int code;
	private String licensePlate;

	public Bus() {
		code = 0;
		licensePlate = " ";

	}

	public Bus(int code, String licensePlate) {
		this.code = code;
		this.licensePlate = licensePlate;

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

}
