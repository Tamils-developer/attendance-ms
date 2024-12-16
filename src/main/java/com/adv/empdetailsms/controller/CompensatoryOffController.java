package com.adv.empdetailsms.controller;

import static com.adv.empdetailsms.constants.PathConstants.COMPOFF_DETAILS_ENDPOINT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adv.empdetailsms.dto.CompensatoryOffDto;
import com.adv.empdetailsms.servcies.CompensatoryOffService;

@RestController
@RequestMapping(path = COMPOFF_DETAILS_ENDPOINT)
//@CrossOrigin(origins = "http://localhost:3006")
public class CompensatoryOffController {

	@Autowired
	@Qualifier(value = "compensatoryOffServiceImpl")
	private CompensatoryOffService compensatoryOffService;

	@GetMapping
	public ResponseEntity<List<CompensatoryOffDto>> getAllCompOfDetails(@RequestHeader(name = "empId", required = true) String empId) {
		return new ResponseEntity<>(compensatoryOffService.getCompOffDetails(empId), HttpStatus.OK);
	}

}
