package com.adv.empdetailsms.controller;

import static com.adv.empdetailsms.constants.PathConstants.LEAVE_DETAILS_ENDPOINT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adv.empdetailsms.dto.LeaveDetailsDto;
import com.adv.empdetailsms.servcies.LeaveDetailsService;

@RestController
@RequestMapping(path = LEAVE_DETAILS_ENDPOINT)
public class LeaveDetailsController {

	@Autowired
	private LeaveDetailsService leaveDetailsService;

	@GetMapping
	public ResponseEntity<LeaveDetailsDto> getLeaveDetails(@RequestHeader("empId") String empId) {
		return new ResponseEntity<LeaveDetailsDto>(leaveDetailsService.getLeaveDetails(empId), HttpStatus.OK);
	}
}
