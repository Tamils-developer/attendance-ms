package com.adv.empdetailsms.servcies.impl;

import static com.adv.empdetailsms.constants.ErrorConstants.*;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.empdetailsms.dto.LeaveDetailsDto;
import com.adv.empdetailsms.entity.LeaveDetailsEntity;
import com.adv.empdetailsms.exceptions.InvalidEmployeeIdExecption;
import com.adv.empdetailsms.repository.LeaveDetailsRepository;
import com.adv.empdetailsms.servcies.LeaveDetailsService;

@Service
public class LeaveDetailsServiceImpl implements LeaveDetailsService {

	@Autowired
	private LeaveDetailsRepository leaveRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public LeaveDetailsDto getLeaveDetails(String empId) {

		if (Objects.nonNull(empId) && !empId.isBlank()) {
			LeaveDetailsDto leaveDetailsDto = new LeaveDetailsDto();
			LeaveDetailsEntity leaveEntity = leaveRepository.findByEmpId(empId);

			if (leaveEntity == null || Objects.isNull(leaveEntity.getId())) {
				throw new InvalidEmployeeIdExecption(ERROR_CODE_1002, ERROR_MESSAGE_1002);
			}
			mapper.map(leaveEntity, leaveDetailsDto);
			return leaveDetailsDto;
		} else {
			throw new InvalidEmployeeIdExecption(ERROR_CODE_1001, ERROR_MESSAGE_1001);
		}
	}
}
