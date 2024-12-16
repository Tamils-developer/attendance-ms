package com.adv.empdetailsms.servcies.impl;

import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_CODE_1001;
import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_CODE_1002;
import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_CODE_1003;
import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_MESSAGE_1001;
import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_MESSAGE_1002;
import static com.adv.empdetailsms.constants.ErrorConstants.ERROR_MESSAGE_1003;
import static com.adv.empdetailsms.constants.ValidationConstants.PENDING;
import static com.adv.empdetailsms.utils.ValidationHelper.isValid;
import static com.adv.empdetailsms.utils.ValidationHelper.isValidList;
import static com.adv.empdetailsms.utils.ValidationHelper.isValidModel;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.empdetailsms.dto.ApprovalDto;
import com.adv.empdetailsms.dto.AttendanceDetailsDto;
import com.adv.empdetailsms.dto.WeeklyAttendanceListDto;
import com.adv.empdetailsms.entity.AttendanceDetailsEntity;
import com.adv.empdetailsms.exceptions.DataNotFoundException;
import com.adv.empdetailsms.exceptions.InvalidDataException;
import com.adv.empdetailsms.exceptions.InvalidEmployeeIdExecption;
import com.adv.empdetailsms.repository.AttendanceDetailsRepository;
import com.adv.empdetailsms.servcies.AttendanceDetailsService;

import jakarta.transaction.Transactional;

@Service(value = "attendanceDetailsService")
public class AttendanceDetailsServiceImpl implements AttendanceDetailsService {

	@Autowired
	private AttendanceDetailsRepository attendanceDetailsRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AttendanceDetailsDto createAttendanceDetails(AttendanceDetailsDto attendanceDetailsDto, String empId) {

		if (isValidModel(attendanceDetailsDto) && isValid(attendanceDetailsDto.getEmpId()) && isValid(empId)) {

			if (attendanceDetailsDto.getDate() == null || attendanceDetailsDto.getDate().toString().trim().isBlank()) {
				throw new InvalidDataException(ERROR_CODE_1003, ERROR_MESSAGE_1003);
			}

			Timestamp now = Timestamp.from(Instant.now());
			attendanceDetailsDto.setCreatedBy(empId);
			attendanceDetailsDto.setUpdatedBy(empId);
			attendanceDetailsDto.setCreatedDate(now);
			attendanceDetailsDto.setUpdatedDate(now);
			attendanceDetailsDto.setStatus(PENDING);
			attendanceDetailsDto.setDeleted(false);

			AttendanceDetailsEntity entity = mapper.map(attendanceDetailsDto, AttendanceDetailsEntity.class);
			AttendanceDetailsEntity savedEntity = attendanceDetailsRepository.saveAndFlush(entity);

			return mapper.map(savedEntity, AttendanceDetailsDto.class);
		} else {
			throw new InvalidEmployeeIdExecption(ERROR_CODE_1001, ERROR_MESSAGE_1001);
		}
	}

	@Override
	public List<AttendanceDetailsDto> getAttendanceDetailsForMonth(String empId, String startDate, String endDate) {

		if (isValid(empId) && isValid(endDate) && isValid(startDate)) {

			List<AttendanceDetailsDto> listOfAttendance = new ArrayList<>();
			listOfAttendance = Optional
					.ofNullable(attendanceDetailsRepository.findByEmpIdAndBetweenDates(empId, startDate, endDate))
					.filter(list -> !list.isEmpty())
					.orElseThrow(() -> new DataNotFoundException(ERROR_CODE_1002, ERROR_MESSAGE_1002)).stream()
					.map(data -> mapper.map(data, AttendanceDetailsDto.class)).toList();

			return listOfAttendance;

		} else {
			throw new InvalidEmployeeIdExecption(ERROR_CODE_1001, ERROR_MESSAGE_1001);
		}
	}

	@Override
	public List<ApprovalDto> getAttendanceDetailsForApproval(String approverId) {

		if (isValid(approverId)) {
			List<AttendanceDetailsDto> listOfAttendance = Optional
					.ofNullable(attendanceDetailsRepository.findByApproverIdAndStatus(approverId, PENDING))
					.filter(list -> !list.isEmpty())
					.orElseThrow(() -> new DataNotFoundException(ERROR_CODE_1002, ERROR_MESSAGE_1002)).stream()
					.map(data -> mapper.map(data, AttendanceDetailsDto.class)).toList();

			Map<String, ApprovalDto> approvalMap = new HashMap<>();

			for (AttendanceDetailsDto attendance : listOfAttendance) {
				LocalDate attDate = attendance.getDate();
				int weekNumber = attDate.get(WeekFields.ISO.weekOfYear());
				String empId = attendance.getEmpId();
				ApprovalDto approvalDto = approvalMap.computeIfAbsent(empId, id -> {
					ApprovalDto dto = new ApprovalDto();
					dto.setId(id);
					dto.setWeeklyAttendance(new ArrayList<>());
					return dto;
				});

				List<WeeklyAttendanceListDto> weeklyAttendance = approvalDto.getWeeklyAttendance();
				WeeklyAttendanceListDto weeklyDto = weeklyAttendance.stream()
						.filter(week -> week.getWeekNumber() == weekNumber).findFirst().orElseGet(() -> {
							WeeklyAttendanceListDto newWeek = new WeeklyAttendanceListDto(weekNumber,
									new ArrayList<>());
							weeklyAttendance.add(newWeek);
							return newWeek;
						});

				weeklyDto.getListOfAttendance().add(attendance);
			}

			return new ArrayList<>(approvalMap.values());

		} else {
			throw new InvalidDataException(ERROR_CODE_1003, ERROR_MESSAGE_1003);
		}

	}

	@Override
	@Transactional
	public boolean updateAttendanceDetails(AttendanceDetailsDto attendanceDetailsDto, String empId, String attendId) {

		if (isValidModel(attendanceDetailsDto) && isValid(attendId) && isValid(attendanceDetailsDto.getEmpId())
				&& isValid(attendanceDetailsDto.getStatus())) {
			String approverId = attendanceDetailsDto.getApproverId();
			String empIdFromDto = attendanceDetailsDto.getEmpId();
			String currentStatus = attendanceDetailsDto.getStatus().toUpperCase();
			Boolean isUpdated = attendanceDetailsRepository.updateAttendanceAndCompOffDetails(attendId, approverId,
					empIdFromDto, currentStatus);
			System.out.println(isUpdated.booleanValue());
			return isUpdated;
		} else {
			throw new InvalidEmployeeIdExecption(ERROR_CODE_1001, ERROR_MESSAGE_1001);
		}
	}

	@Override
	public void updateAttendanceDetails(List<AttendanceDetailsDto> listOfAttendance, String empId) {
		if (isValidList(listOfAttendance) && isValid(empId)) {
			listOfAttendance.forEach(dto -> updateAttendanceDetails(dto, empId, dto.getId()));
		} else {
			throw new InvalidEmployeeIdExecption(ERROR_CODE_1001, ERROR_MESSAGE_1001);
		}
	}

	@Override
	public List<AttendanceDetailsDto> getPreviousApplies(String empId) {
		if (isValid(empId)) {
			List<AttendanceDetailsDto> listOfAttendance = Optional
					.ofNullable(attendanceDetailsRepository.findByEmpIdByLimit(empId, 5))
					.filter(list -> !list.isEmpty())
					.orElseThrow(() -> new DataNotFoundException(ERROR_CODE_1002, ERROR_MESSAGE_1002)).stream()
					.map(data -> mapper.map(data, AttendanceDetailsDto.class)).toList();
			return listOfAttendance;

		} else {
			throw new InvalidEmployeeIdExecption(ERROR_CODE_1001, ERROR_MESSAGE_1001);
		}
	}

}
