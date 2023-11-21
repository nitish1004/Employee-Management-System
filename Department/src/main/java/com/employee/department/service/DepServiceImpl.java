package com.employee.department.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.department.exception.DepartmentAlreadyExist;
import com.employee.department.exception.DepartmentNotFound;
import com.employee.department.exception.DepartmentNotFound;
import com.employee.department.model.Department;
import com.employee.department.model.employee;
import com.employee.department.repository.DepRepository;

@Service
public class DepServiceImpl implements DepService {

	@Autowired
	private DepRepository repo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Department createDepartment(Department department) {
		if(repo.existsById(department.getDepartmentId())) {
			throw new DepartmentAlreadyExist("Department Already Exist with ID "+ department.getDepartmentId());
		}if(repo.existsByDepartmentName(department.getDepartmentName())) {
			throw new DepartmentAlreadyExist("Department Already Exist with Name "+ department.getDepartmentName());
		}
		Department dep = repo.save(department);
		return dep;
	}

	@Override
	public Department updateDepartment(Department updatedDepartment) {
		Department dep = repo.save(updatedDepartment);
		return dep;
	}

	@Override
	public Department getDepartmentById(long departmentId) {
		if(repo.existsById(departmentId)) {
			Department dep = repo.findById(departmentId).get();
			List<employee> list = restTemplate.getForObject("http://localhost:8081/emp/dept/" + dep.getDepartmentId(),
					List.class);
			dep.setEmployee(list);
			return dep;
		}
		else {
			throw new DepartmentNotFound("Department not found with Id "+ departmentId);
		}
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> dep = repo.findAll();
		return dep;
	}

	@Override
	public String deleteDepartment(long departmentId) {
		if(repo.existsById(departmentId)) {
		repo.deleteById(departmentId);
		return "Department Deleted";
		}else {
			throw new DepartmentNotFound("department not found with ID "+departmentId);
		}
	}

	@Override
	public Department getemployeedept(String departmentName) {
		Department dep = repo.findByDepartmentNameContainingIgnoreCase(departmentName);
		return dep;
	}

}
