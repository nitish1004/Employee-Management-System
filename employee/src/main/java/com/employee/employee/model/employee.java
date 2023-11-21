package com.employee.employee.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class employee {
	
	
	@Id
	private long empId;
	
	@Size(min =2,max=20, message = "size should be with in 2 and 20")
	private String empname;
	private String address;
	private String email;
	private String phoneNumber;
	private Date hiredate;
	private long departmentId;
	
	@Transient
	private Department departmentdetails;

}
