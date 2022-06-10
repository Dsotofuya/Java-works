package edu.uptc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RealStateID  implements Serializable{
	private static final long serialVersionUID = 6485406412363395170L;
	@Column(name = "address")
	private String address;
	@Column(name = "block")
	private String block;
	@Column(name = "internal_id")
	private int internal_id;
	public RealStateID(String address, String block, int internal_id) {
		super();
		this.address = address;
		this.block = block;
		this.internal_id = internal_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public int getInternal_id() {
		return internal_id;
	}
	public void setInternal_id(int internal_id) {
		this.internal_id = internal_id;
	}
}