package com.adv.empdetailsms.servcies.impl;

import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_CODE_1001;
import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_MESSAGE_1001;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.empdetailsms.entity.RoosterDto;
import com.adv.empdetailsms.entity.RoosterEntity;
import com.adv.empdetailsms.exceptions.InvalidEmployeeIdExecption;
import com.adv.empdetailsms.repository.RoosterRepository;
import com.adv.empdetailsms.servcies.RoosterDetailsService;
import com.adv.empdetailsms.utils.ValidationHelper;

@Service
public class RoosterDetailsServiceImpl implements RoosterDetailsService {

	@Autowired
	private RoosterRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<RoosterDto> createRoosterDetails(List<RoosterDto> roosterDtos) {

		if (ValidationHelper.isValidList(roosterDtos)) {
			List<RoosterEntity> listOfRoosters = roosterDtos.stream().peek(data -> {
				LocalDate w1 = data.getWeekOffOne();
				LocalDate startDate = w1.with(DayOfWeek.MONDAY);
				LocalDate endDate = w1.with(DayOfWeek.SUNDAY);
				data.setCreatedBy(data.getEmpId());
				data.setUpdatedBy(data.getEmpId());
				data.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
				data.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
				data.setStartDate(startDate);
				data.setEndDate(endDate);

			}).map(e -> mapper.map(e, RoosterEntity.class)).toList();
			System.out.println(listOfRoosters);
			List<RoosterEntity> saveAllAndFlush = repository.saveAllAndFlush(listOfRoosters);

			return saveAllAndFlush.stream().map(e -> mapper.map(e, RoosterDto.class)).toList();
		} else {
			throw new InvalidEmployeeIdExecption(ERROR_CODE_1001, ERROR_MESSAGE_1001);
		}
	}

}
//
//data -> {
//	LocalDate w1 = data.getWeekOffOne();
//	LocalDate startDate = w1.with(DayOfWeek.MONDAY);
//	LocalDate endDate = w1.with(DayOfWeek.SUNDAY);
//	
//
//	data.setCreatedBy(data.getEmpId());
//	data.setUpdatedBy(data.getEmpId());
//	data.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
//	data.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
//	data.setStartDate(startDate);
//	data.setEndDate(endDate);
//	
//	RoosterEntity roosterEntity = mapper.convertValue(data, RoosterEntity.class);
//	
