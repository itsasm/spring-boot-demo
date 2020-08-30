package com.java.api.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //student default bean id
@Scope(value = "prototype")
public class Student {

	private int rollNo;
	private String firtsName;
	private String lastName;
	private String DOB;
	private String address;
	
	@Autowired
	@Qualifier("c1")
	private Course course;

	public Student() {
		System.out.println("In Student Contructor.....");
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getFirtsName() {
		return firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void show() {
		System.out.println("In Studetn show().....");
		course.compile();
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", firtsName=" + firtsName + ", lastName=" + lastName + ", DOB=" + DOB
				+ ", address=" + address + "]";
	}

}
