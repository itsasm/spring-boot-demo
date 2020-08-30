package com.java.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int HNo;
	private String street;
	private int pincode;

	public Address(int id, int HNo, String street, int pincode) {
		super();
		this.id = id;
		this.HNo = HNo;
		this.street = street;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "{" + HNo + ", " + street + ", " + pincode + "}";
	}

}
