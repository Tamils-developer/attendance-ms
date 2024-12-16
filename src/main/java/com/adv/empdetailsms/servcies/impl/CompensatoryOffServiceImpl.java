package com.adv.empdetailsms.servcies.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.empdetailsms.constants.ErrorConstants;
import com.adv.empdetailsms.dto.CompensatoryOffDto;
import com.adv.empdetailsms.entity.CompensatoryOffEntity;
import com.adv.empdetailsms.exceptions.InvalidEmployeeIdExecption;
import com.adv.empdetailsms.repository.CompensatoryOffRepository;
import com.adv.empdetailsms.servcies.CompensatoryOffService;

@Service(value = "compensatoryOffServiceImpl")
public class CompensatoryOffServiceImpl implements CompensatoryOffService {

	@Autowired
	private CompensatoryOffRepository compensatoryOffRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CompensatoryOffDto> getCompOffDetails(String empId ) {
		if (empId != null && !empId.isBlank() && !empId.isEmpty()) {
			List<CompensatoryOffDto> listOfCompOffDetails = new ArrayList<>();

			List<CompensatoryOffEntity> listOfCompOffEntity = compensatoryOffRepository.findAllByEmpIdAndStatus(empId,"OPEN");
			listOfCompOffEntity.stream().forEach((data) -> {
				listOfCompOffDetails.add(mapper.map(data, CompensatoryOffDto.class));
			});
			return listOfCompOffDetails;
		} else {
			throw new InvalidEmployeeIdExecption(ErrorConstants.ERROR_CODE_1004, ErrorConstants.ERROR_MESSAGE_1004);
		}
	}

}
