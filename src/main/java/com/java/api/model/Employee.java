package com.java.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	private List<Address> addresses;

	public Employee(int id, String name, int age, List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + age + ", " + addresses;
	}
}
