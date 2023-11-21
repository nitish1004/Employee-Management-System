package com.employee.department.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Department")
public class Department {
	
	@Id
	private long departmentId;
	private String departmentName;
	private String descripation;
	private String managerName;
	private String location;
	private List<employee> employee;
	


}
