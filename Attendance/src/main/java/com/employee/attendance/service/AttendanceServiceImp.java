package com.employee.attendance.service;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.attendance.model.Attendance;
import com.employee.attendance.repository.AttendanceRepository;

@Service
public class AttendanceServiceImp implements AttendanceService{
	
	@Autowired
	private AttendanceRepository repo;

	@Override
	public Attendance createattendance(Attendance attendance) {
		Attendance att = repo.save(attendance);
		return att;
	}

	@Override
	public List<Attendance> getAttendanceByEmployeeId(long employeeId) {
		List<Attendance> list = repo.findByEmployeeId(employeeId);
		return list;
	}

	@Override
	public List<Attendance> getAllAttendance() {
		List<Attendance> list = repo.findAll();
		return list;
	}
	
	@Override
	public Attendance updateattendance(Attendance atte) {
		Attendance att = repo.save(atte);
		return att;
	}
	
	@Override
	public String deleteattendance(long attendanceId) {
		repo.deleteById(attendanceId);
		return "AttendanceId Deleted";
	}

	/*
	 * @Override public List<Attendance> getAddendancebyateange(Date startdate, Date
	 * enddate) { List<Attendance> list = repo.findByclockInTimeBetween(startdate,
	 * startdate); return list; }
	 */

}
