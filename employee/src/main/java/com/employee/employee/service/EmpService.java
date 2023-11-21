package com.employee.employee.service;

import java.util.List;

import com.employee.employee.exception.EmployeeIdNotFound;
import com.employee.employee.exception.EmpolyeeAlreadyExists;
import com.employee.employee.model.employee;

public interface EmpService {
	employee addemploye(employee emp) throws EmpolyeeAlreadyExists; //return ()name arrgs
	List<employee> allemployes();
	employee getemployeebyid(long empid) throws EmployeeIdNotFound;
	employee updateemployee(employee emp);

}
