package com.educo.attendanceModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educo.attendanceModule.model.Attendance;
import com.educo.attendanceModule.service.AttendanceService;

@RequestMapping("/attendance")
@RestController
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	
	@PostMapping("/markAttendance")
	public ResponseEntity<String> markAttandance(@RequestBody List<Attendance> attendanceList) {
		String status = attendanceService.markAttendance(attendanceList);
		
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@GetMapping("/retrieveAttendance")
	public ResponseEntity<Attendance> getAttendance(@RequestBody String userId) {
		Attendance attendance = attendanceService.getUserAttendance(userId);
		return new ResponseEntity<Attendance>(attendance, HttpStatus.OK);
	}
	
	@PutMapping("/approveAttendance")
	public void approveAttendance(@RequestBody Attendance attendance) {
		
	}
	
}
