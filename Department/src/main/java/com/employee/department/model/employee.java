package com.employee.department.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class employee {
	@Id
	private long empId;
	private String empname;
	private String address;
	private String email;
	private String phoneNumber;
	private Date hiredate;

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public employee(long empId, String empname, String address, String email, String phoneNumber, Date hiredate) {
		super();
		this.empId = empId;
		this.empname = empname;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hiredate = hiredate;
	}

	public employee() {
		super();
	}

}
