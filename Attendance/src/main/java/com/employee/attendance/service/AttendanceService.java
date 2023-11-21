package com.employee.attendance.service;

//import java.util.Date;
import java.util.List;

import com.employee.attendance.model.Attendance;

public interface AttendanceService {
	
	 Attendance createattendance(Attendance attendance);
	
	 List<Attendance> getAttendanceByEmployeeId(long employeeId);
	
	 List<Attendance> getAllAttendance();
	 
	 //List<Attendance> getAddendancebyateange(Date startdate, Date enddate);

	Attendance updateattendance(Attendance atte);

	String deleteattendance(long attendanceId);
	
	

}
