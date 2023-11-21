package com.employee.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.department.model.Department;
import com.employee.department.service.DepServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("dept")
public class DepController {
	
	@Autowired
	private DepServiceImpl service;
	
	@Operation(summary = "Add a new Department", description = "Endpoint to add a new Department", operationId = "addDepartment")
	@PostMapping("adddepartment")
	public ResponseEntity<Department> adddepartment(@RequestBody Department department){
		Department dep =service.createDepartment(department);
		return new ResponseEntity<Department>(dep,HttpStatus.CREATED);
	}
	@Operation(summary = "Add alldepartment", description = "Endpoint to alldepartment", operationId = "alldepartment")
	@GetMapping("alldepartment")
	public ResponseEntity<List<Department>> getalldepartment(){
		List<Department> list = service.getAllDepartments();
		return new ResponseEntity<List<Department>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Add departmentid", description = "Endpoint to departmentid", operationId = "departmentid")
	@GetMapping("{departmentid}")
	public ResponseEntity<Department> getdepbyid(@PathVariable("departmentid") long departmentId){
		Department dep=service.getDepartmentById(departmentId);
		return new ResponseEntity<Department>(dep, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "updatedep", description = "Endpoint to updatedep", operationId = "updatedep")
	@PutMapping("updatedep")
	public ResponseEntity<Department> updatedepartment(@RequestBody Department department){
		Department dep=service.updateDepartment(department);
		return new ResponseEntity<Department>(dep, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "deletdepartmentid", description = "Endpoint to deletdepartmentid", operationId = "deletdepartmentid")
	@DeleteMapping("{departmentid}")
	public ResponseEntity<String> deletedepartmentid(@PathVariable ("departmentid") long departmentId){
	String dep = service.deleteDepartment(departmentId);
	return new ResponseEntity<String>(dep, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "departmentName", description = "Endpoint to departmentName", operationId = "departmentName")
	@GetMapping("depname/{departmentName}")
	public ResponseEntity<Department> getbydepartmentname(@PathVariable("departmentName") String departmentName){
		Department dep=service.getemployeedept(departmentName);
		return new ResponseEntity<Department>(dep, HttpStatus.ACCEPTED);
	}

}
