package com.adv.empdetailsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adv.empdetailsms.entity.RoosterDto;
import com.adv.empdetailsms.servcies.RoosterDetailsService;

@RestController
public class RoosterController {

	@Autowired
	private RoosterDetailsService detailsService;

	@PostMapping(path = "/rooster")
	public ResponseEntity<List<RoosterDto>> createRoosterDetails(@RequestBody List<RoosterDto> list) {
		return new ResponseEntity<List<RoosterDto>>(detailsService.createRoosterDetails(list), HttpStatus.OK);
	}
}
