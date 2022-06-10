package edu.uptc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
//	@ManyToOne(cascade = {CascadeType.ALL})
//	private Admin admin;

	public RealState() {
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

//	public Admin getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}
}
