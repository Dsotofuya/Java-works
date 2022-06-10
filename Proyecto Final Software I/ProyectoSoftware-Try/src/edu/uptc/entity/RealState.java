package edu.uptc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "real_states")
public class RealState implements Serializable{
	private static final long serialVersionUID = 4033627448194380926L;
	@EmbeddedId
	private RealStateID realStateID;
	@Column(name = "real_state_type_id")
	@Enumerated(EnumType.ORDINAL)
	private RealStateEnum realStateEnum;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_id", insertable = true)
	private Admin admin;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "resident_id")
    private Resident resident;
	
	public RealState(RealStateID realStateID, RealStateEnum realStateEnum, Admin admin, Resident resident) {
		super();
		this.realStateID = realStateID;
		this.realStateEnum = realStateEnum;
		this.admin = admin;
		this.resident = resident;
	}

	public RealStateID getRealStateID() {
		return realStateID;
	}

	public void setRealStateID(RealStateID realStateID) {
		this.realStateID = realStateID;
	}

	public RealStateEnum getRealStateEnum() {
		return realStateEnum;
	}

	public void setRealStateEnum(RealStateEnum realStateEnum) {
		this.realStateEnum = realStateEnum;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}
}
