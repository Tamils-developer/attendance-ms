package com.adv.empdetailsms.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyAttendanceListDto {

	private int weekNumber;

	private List<AttendanceDetailsDto> listOfAttendance;
}
