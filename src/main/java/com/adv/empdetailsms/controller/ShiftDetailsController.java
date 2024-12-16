package com.adv.empdetailsms.controller;

import static com.adv.empdetailsms.constants.PathConstants.SHIFT_DETAILS_ENDPOINT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adv.empdetailsms.dto.ShiftDetailsDto;
import com.adv.empdetailsms.servcies.ShiftDetailsService;

@RestController
public class ShiftDetailsController {

	@Autowired
	@Qualifier(value = "shiftDetailService")
	private ShiftDetailsService shiftDetailService;

	@GetMapping(path = SHIFT_DETAILS_ENDPOINT)
	public ResponseEntity<List<ShiftDetailsDto>> getAllShiftDetails() {
		return new ResponseEntity<List<ShiftDetailsDto>>(shiftDetailService.getAllShiftdetails(), HttpStatus.OK);
	}
}
