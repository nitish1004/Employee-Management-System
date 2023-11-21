package com.employee.employee.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.employee.model.employee;

public interface EmpRepository extends MongoRepository<employee, Long> {

	List<employee> findByDepartmentId(long departmentId);

}
