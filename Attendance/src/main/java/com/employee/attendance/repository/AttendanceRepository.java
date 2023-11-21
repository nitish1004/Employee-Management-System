package com.employee.attendance.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.attendance.model.Attendance;

public interface AttendanceRepository extends MongoRepository<Attendance, Long> {

	List<Attendance> findByEmployeeId(long employeeId);

	List<Attendance> findByclockInTimeBetween(Date startdate, Date enddate);

}