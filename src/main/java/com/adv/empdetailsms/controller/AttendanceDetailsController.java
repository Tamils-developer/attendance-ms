package com.adv.empdetailsms.controller;

import static com.adv.empdetailsms.constants.PathConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adv.empdetailsms.dto.ApprovalDto;
import com.adv.empdetailsms.dto.AttendanceDetailsDto;
import com.adv.empdetailsms.servcies.AttendanceDetailsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = ATTENDANCE_BASE_ENDPOINT)
public class AttendanceDetailsController {

	@Autowired
	@Qualifier(value = "attendanceDetailsService")
	private AttendanceDetailsService attendanceDetailsService;

	@PostMapping
	public ResponseEntity<AttendanceDetailsDto> createAttendanceDetails(
			@Valid @RequestBody AttendanceDetailsDto attendanceDetailsDto,
			@RequestHeader(name = "empId", required = true) String empId) {
		System.out.println(empId);
		return new ResponseEntity<AttendanceDetailsDto>(
				attendanceDetailsService.createAttendanceDetails(attendanceDetailsDto, empId), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<AttendanceDetailsDto>> getAttendanceDetailsForMonth(
			@RequestHeader(name = "empId", required = true) String empId,
			@RequestParam(required = true) String startDate, @RequestParam(required = true) String endDate) {
		return new ResponseEntity<List<AttendanceDetailsDto>>(
				attendanceDetailsService.getAttendanceDetailsForMonth(empId, startDate, endDate), HttpStatus.OK);
	}

	@GetMapping(path = APPROVAL_ENDPOINT)
	public ResponseEntity<List<ApprovalDto>> getAttendanceDetailsForApproval(
			@RequestHeader(name = "empId", required = true) String approverId) {
		return new ResponseEntity<List<ApprovalDto>>(
				attendanceDetailsService.getAttendanceDetailsForApproval(approverId), HttpStatus.OK);
	}

	@PatchMapping(path = "/{attendId}")
	public ResponseEntity<Boolean> updateAttendanceDetails(
			@Valid @RequestBody AttendanceDetailsDto attendanceDetailsDto,
			@RequestHeader(name = "empId", required = true) String empId,
			@PathVariable(name = "attendId", required = true) String attendId) {
		return new ResponseEntity<Boolean>(
				attendanceDetailsService.updateAttendanceDetails(attendanceDetailsDto, empId, attendId), HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<Void> updateAttendanceDetails(@RequestBody List<AttendanceDetailsDto> listOfAttendance,
			@RequestHeader(name = "empId", required = true) String empId) {
		attendanceDetailsService.updateAttendanceDetails(listOfAttendance, empId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping(path = PREVIOUS)
	public ResponseEntity<List<AttendanceDetailsDto>> getPreviousApplies(
			@RequestHeader(name = "empId", required = true) String empId) {
		return new ResponseEntity<List<AttendanceDetailsDto>>(attendanceDetailsService.getPreviousApplies(empId),
				HttpStatus.OK);
	}
}
