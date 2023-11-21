package com.employee.employee.model;

//import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	@JsonIgnore
	private long departmentId;
	private String departmentName;
	private String descripation;
	private String managerName;
	private String location;

}
