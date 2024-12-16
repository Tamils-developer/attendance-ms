package com.adv.empdetailsms.servcies.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.empdetailsms.dto.ShiftDetailsDto;
import com.adv.empdetailsms.entity.ShiftDetailsEntity;
import com.adv.empdetailsms.repository.ShiftDetailsRepository;
import com.adv.empdetailsms.servcies.ShiftDetailsService;

@Service(value = "shiftDetailService")
public class ShiftDetailsServiceImpl implements ShiftDetailsService {

	@Autowired
	private ShiftDetailsRepository shiftDetailsRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<ShiftDetailsDto> getAllShiftdetails() {
		List<ShiftDetailsDto> detailsDtos = new ArrayList<>();
		List<ShiftDetailsEntity> shiftDetailsList = shiftDetailsRepo.findAll();
		shiftDetailsList.stream().forEach(data -> detailsDtos.add( mapper.map(data,ShiftDetailsDto.class)));
		return detailsDtos;
	}

}
