package com.adv.empdetailsms.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalDto {

	@NotNull
	private String id;
	@NotNull
	private List<WeeklyAttendanceListDto> weeklyAttendance;
}
