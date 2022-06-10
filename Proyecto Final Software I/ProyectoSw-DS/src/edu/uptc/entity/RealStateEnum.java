package edu.uptc.entity;

public enum RealStateEnum {
	APARTMENT(0), HOUSE(1), COMMUNAL_LIVING(2), SOCCER_FIELD(3);

	private int realStateTypeID;

	private RealStateEnum(int realStateTypeID) {
		this.realStateTypeID = realStateTypeID;
	}

	public int getRealStateTypeID() {
		return realStateTypeID;
	}

	public void setRealStateTypeID(int realStateTypeID) {
		this.realStateTypeID = realStateTypeID;
	}
}