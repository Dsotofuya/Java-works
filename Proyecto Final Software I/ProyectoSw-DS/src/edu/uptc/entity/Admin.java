package edu.uptc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin implements Serializable{
	private static final long serialVersionUID = 6412538388289111906L;
	@Id
	@Column(name = "admin_id")
	private String admin_id;
	@Column(name = "admin_name")
	private String admin_name;
	@Column(name = "admin_phone")
	private String admin_phone;
//	@OneToMany(mappedBy = "admin", cascade = {CascadeType.ALL}, orphanRemoval = true)
//	private List<RealState> realStates;

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_phone() {
		return admin_phone;
	}

	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
//
//	public List<RealState> getRealStates() {
//		return realStates;
//	}
//
//	public void setRealStates(List<RealState> realStates) {
//		this.realStates = realStates;
//	}
}
