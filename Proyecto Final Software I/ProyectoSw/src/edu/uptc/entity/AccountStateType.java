package edu.uptc.entity;

public enum AccountStateType {
	CREADA(0), CON_DEUDA(1), AL_DIA(2), EN_ACUERDO_PAGO(3), MOROSO(4), COBRO_COACTIVO(5), PROCESO_EMBARGO(6);

	private int accountStateID;

	private AccountStateType(int realStateTypeID) {
		this.accountStateID = realStateTypeID;
	}
	
	public int getRealStateTypeID() {
		return accountStateID;
	}
	
	public void setRealStateTypeID(int realStateTypeID) {
		this.accountStateID = realStateTypeID;
	}
}
