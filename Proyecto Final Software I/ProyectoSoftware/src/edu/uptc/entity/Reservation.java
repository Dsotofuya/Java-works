package edu.uptc.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 8702104788563802739L;
	@Id
	@Column(name = "reservation_id")
	private int reservation_id;

	@OneToOne(mappedBy = "reservation", cascade = { CascadeType.ALL })
	@JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id")
	private Resident resident;

	@Column(name = "reservation_date")
	private Date reservation_date;

	@Column(name = "ending_hour")
	private Time ending_hour;
	
	@Column(name = "starting_hour")
	private Time starting_hour;

	@Embedded
	private RealStateID realStateID;

	public Reservation(int reservation_id, Resident resident, Date reservation_date, Time ending_hour,
			Time starting_hour, RealStateID realStateID) {
		super();
		this.reservation_id = reservation_id;
		this.resident = resident;
		this.reservation_date = reservation_date;
		this.ending_hour = ending_hour;
		this.starting_hour = starting_hour;
		this.realStateID = realStateID;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public Date getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}
	
	public Time getEnding_hour() {
		return ending_hour;
	}

	public void setEnding_hour(Time ending_hour) {
		this.ending_hour = ending_hour;
	}

	public Time getStarting_hour() {
		return starting_hour;
	}

	public void setStarting_hour(Time starting_hour) {
		this.starting_hour = starting_hour;
	}

	public RealStateID getRealStateID() {
		return realStateID;
	}

	public void setRealStateID(RealStateID realStateID) {
		this.realStateID = realStateID;
	}

	@Override
	public String toString() {
		return "Reservation [reservation_id=" + reservation_id + ", resident=" + resident + ", reservation_date="
				+ reservation_date + ", ending_hour=" + ending_hour + ", starting_hour=" + starting_hour
				+ ", realStateID=" + realStateID.toString() + "]";
	}
	
	
}
