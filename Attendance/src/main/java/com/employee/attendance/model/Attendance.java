package com.employee.attendance.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Attendance")
public class Attendance {
	
	@Id
	private long attendanceId;
	private long employeeId;
	private Date clockInTime;
	private Date clockOutTime;
	private leavetype leavetype;
	private boolean approved;

}
