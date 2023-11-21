package com.employee.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.employee.exception.EmployeeIdNotFound;
import com.employee.employee.exception.EmpolyeeAlreadyExists;
import com.employee.employee.model.Department;
import com.employee.employee.model.employee;
import com.employee.employee.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;//use to communicate between microservices

	//addemploye
	@Override
	public employee addemploye(employee emp) throws EmpolyeeAlreadyExists {
		if (repo.existsById(emp.getEmpId())) {
			throw new EmpolyeeAlreadyExists("Employee already exists " + emp.getEmpId());
		}
		employee e = repo.save(emp);
		return e;
	}

	//allemployes
	@Override
	public List<employee> allemployes() {
		//if(repo.findAll())
		List<employee> list = repo.findAll();
		return list;
	}

	//getemployeebyid
	@Override
	public employee getemployeebyid(long empId) throws EmployeeIdNotFound {
		if (repo.existsById(empId)) {
			employee e = repo.findById(empId).get();
			Department department=restTemplate.getForObject("http://localhost:8082/dept/"+e.getDepartmentId(), Department.class);
			e.setDepartmentdetails(department);
			return e;
		} else {
			throw new EmployeeIdNotFound("Employeeid not found " + empId);
		}

	}

	//updateemployee
	@Override
	public employee updateemployee(employee emp) {
		employee e = repo.save(emp);
		return e;
	}
	
	//List of employees in department
	public List<employee> getbydepartmentId(long departmentId) {
		List<employee> list=repo.findByDepartmentId(departmentId);
		return list;
	}

}
