package edu.uptc.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "residents")
public class Resident implements Serializable {
	private static final long serialVersionUID = -9052313410222202916L;
	@Id
	@Column(name = "resident_id")
	private String resident_id;
	@Column(name = "resident_name")
	private String resident_name;
	@Column(name = "resident_last_name")
	private String resident_last_name;
	@Column(name = "resident_phone_number")
	private String resident_phone_number;
	@Column(name = "account_state_type_id")
	@Enumerated(EnumType.ORDINAL)
	private AccountStateType accountStateType;
	@OneToMany(mappedBy = "resident")
	private List<RealState> realStates;

	public Resident() {
		initRealStatesList();
	}

	public Resident(String resident_id, String resident_name, String resident_last_name, String resident_phone_number,
			AccountStateType accountStateType, List<RealState> realStates) {
		super();
		initRealStatesList();
		this.resident_id = resident_id;
		this.resident_name = resident_name;
		this.resident_last_name = resident_last_name;
		this.resident_phone_number = resident_phone_number;
		this.accountStateType = accountStateType;
		this.realStates = realStates;
	}
	
	public void initRealStatesList() {
		realStates = new LinkedList<>();
	}

	public String getResident_id() {
		return resident_id;
	}

	public void setResident_id(String resident_id) {
		this.resident_id = resident_id;
	}

	public String getResident_name() {
		return resident_name;
	}

	public void setResident_name(String resident_name) {
		this.resident_name = resident_name;
	}

	public String getResident_last_name() {
		return resident_last_name;
	}

	public void setResident_last_name(String resident_last_name) {
		this.resident_last_name = resident_last_name;
	}

	public String getResident_phone_number() {
		return resident_phone_number;
	}

	public void setResident_phone_number(String resident_phone_number) {
		this.resident_phone_number = resident_phone_number;
	}

	public List<RealState> getRealStates() {
		return realStates;
	}

	public void setRealStates(List<RealState> realStates) {
		this.realStates = realStates;
	}

	public AccountStateType getAccountStateType() {
		return accountStateType;
	}

	public void setAccountStateType(AccountStateType accountStateType) {
		this.accountStateType = accountStateType;
	}
}
