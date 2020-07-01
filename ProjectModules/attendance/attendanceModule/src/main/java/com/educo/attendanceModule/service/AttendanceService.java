package com.educo.attendanceModule.service;

import java.util.List;

import com.educo.attendanceModule.model.Attendance;

public interface AttendanceService {

	String markAttendance(List<Attendance> attendanceList);

	Attendance getUserAttendance(String userId);
	
	

}
