package com.employee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.exception.EmployeeIdNotFound;
import com.employee.employee.exception.EmpolyeeAlreadyExists;
import com.employee.employee.model.employee;
import com.employee.employee.service.EmpServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("emp")
public class Empcontroller {
	
	@Autowired
	private EmpServiceImpl service;
	
	@Operation(summary = "Add a new Employee", description = "Endpoint to add a new Employee", operationId = "addEmployee")
	@PostMapping("addemployee")
	public ResponseEntity<employee> addemp(@RequestBody employee emp) throws EmpolyeeAlreadyExists {
		employee e = service.addemploye(emp);
		return new ResponseEntity<employee>(e, HttpStatus.CREATED);
	}
	
	@Operation(summary = "get all Employee", description = "Endpoint to get all Employee", operationId = "getAllEmployee")
	@GetMapping("allemployee")
	public ResponseEntity<List<employee>> getemp() {
		List<employee> e = service.allemployes();
		return new ResponseEntity<List<employee>>(e, HttpStatus.ACCEPTED);
	}
	@Operation(summary = "get a Employeebyid", description = "Endpoint to get a Employee", operationId = "getEmployeeById")
	@GetMapping("get/{EmpId}")
	public ResponseEntity<employee> getempbyid(@PathVariable("EmpId") long EmpId) throws EmployeeIdNotFound {
		employee e = service.getemployeebyid(EmpId);
		return new ResponseEntity<employee>(e, HttpStatus.ACCEPTED);
	}
	@Operation(summary = "update a Employee", description = "Endpoint to update a Employee", operationId = "updateEmployee")
	@PutMapping("update")
	public ResponseEntity<employee> updateemp(@RequestBody employee emp) {
		employee e = service.updateemployee(emp);
		return new ResponseEntity<employee>(e, HttpStatus.CREATED);
	}
	@GetMapping("dept/{departmentId}")
	public ResponseEntity <List<employee>> getemployeedepa(@PathVariable("departmentId")long departmentId){
		List<employee> e =service.getbydepartmentId(departmentId);
		return new ResponseEntity<List<employee>>(e, HttpStatus.ACCEPTED);
	}

}
