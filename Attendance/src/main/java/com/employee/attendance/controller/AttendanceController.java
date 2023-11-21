package com.employee.attendance.controller;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.repository.Update;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.attendance.model.Attendance;
import com.employee.attendance.service.AttendanceServiceImp;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

	@Autowired
	private AttendanceServiceImp service;

	@Operation(summary = "addattendance", description = "Endpoint to addattendance", operationId = "addattendance")
	@PostMapping("addattendance")
	public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
		Attendance atte = service.createattendance(attendance);
		return new ResponseEntity<Attendance>(atte, HttpStatus.CREATED);
	}

	@Operation(summary = "ListofemployeeId", description = "Endpoint to ListofemployeeId", operationId = "ListofemployeeId")
	@GetMapping("emp/{employeeId}")
	public ResponseEntity<List<Attendance>> getAttendanceByEmployeeId(@PathVariable("employeeId") long employeeId) {
		List<Attendance> list = service.getAttendanceByEmployeeId(employeeId);
		return new ResponseEntity<List<Attendance>>(list, HttpStatus.ACCEPTED);
	}
	@Operation(summary = "getallattendance", description = "Endpoint to getallattendance", operationId = "getallattendance")
	@GetMapping("getallattendance")
	public ResponseEntity<List<Attendance>> getAllAttendance() {
		List<Attendance> list = service.getAllAttendance();
		return new ResponseEntity<List<Attendance>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "updateattendance", description = "Endpoint to updateattendance", operationId = "updateattendance")
	@PutMapping("updateattendance")
	public ResponseEntity<Attendance> updateattendance(@RequestBody Attendance atte){
		Attendance att =service.updateattendance(atte);
		return new ResponseEntity<Attendance>(att, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "deleteattendance", description = "Endpoint to deleteattendance", operationId = "deleteattendance")
	@DeleteMapping("deleteattendance/{attendanceId}")
	public ResponseEntity<String> deleteattendance(@PathVariable("attendanceId") long attendanceId){
		String att = service.deleteattendance(attendanceId);
		return new ResponseEntity<String>(att,HttpStatus.ACCEPTED);
	}

	/*
	 * @Operation(summary = "attendance-by-date-range", description =
	 * "Endpoint to attendance-by-date-range", operationId =
	 * "attendance-by-date-range")
	 * 
	 * @GetMapping("/attendance-by-date-range/{startdate}/{enddate}") public
	 * ResponseEntity<List<Attendance>>
	 * getAddendancebyateange(@PathVariable("startdate") Date startdate,
	 * 
	 * @PathVariable("enddate") Date enddate) { List<Attendance> list =
	 * service.getAddendancebyateange(startdate, enddate); return new
	 * ResponseEntity<List<Attendance>>(list, HttpStatus.ACCEPTED); }
	 */

	/*
	 * @GetMapping("/attendance-by-date-range") public
	 * ResponseEntity<List<Attendance>> getAttendanceByDateRange(
	 * 
	 * @RequestParam("startdate") @DateTimeFormat(iso =
	 * DateTimeFormat.ISO.DATE_TIME) Date startdate,
	 * 
	 * @RequestParam("enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	 * Date enddate) { List<Attendance> list =
	 * service.getAddendancebyateange(startdate, enddate); return new
	 * ResponseEntity<List<Attendance>>(list, HttpStatus.ACCEPTED); }
	 */

}
