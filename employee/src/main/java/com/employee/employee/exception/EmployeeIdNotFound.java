package com.employee.employee.exception;

public class EmployeeIdNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmployeeIdNotFound(String msg) {
		super();
		this.msg = msg;
	}
	public EmployeeIdNotFound() {
		super();
	} 

}
