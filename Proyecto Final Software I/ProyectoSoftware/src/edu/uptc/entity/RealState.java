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
	private RealStateType realStateType;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_id", insertable = true)
	private Admin admin;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resident_id", referencedColumnName = "resident_id")
    private Resident resident;

	public RealState() {
	}

	public RealStateID getRealStateID() {
		return realStateID;
	}

	public void setRealStateID(RealStateID realStateID) {
		this.realStateID = realStateID;
	}

	public RealStateType getRealStateEnum() {
		return realStateType;
	}

	public void setRealStateEnum(RealStateType realStateEnum) {
		this.realStateType = realStateEnum;
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

	@Override
	public String toString() {
		return "RealState [realStateID=" + realStateID.toString();
	}
	
	
}
