package com.adv.empdetailsms.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties({ "createdDate", "createdBy", "updatedBy", "updatedDate", "isDeleted" })
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDetailsDto {
	
	@NotNull(message = "Id cannot be Null")
	private String id;

	@NotNull(message = "Employee Id cannot be Null")
	private String empId;

	@NotNull(message = "Date cannot be null")
	private LocalDate date;

	@NotNull(message = "Shift Id cannot be null")
	private String shiftId;

	@NotNull(message = "Attendance Id cannot be null")
	private String attendance;
	
	private String status;

	@NotNull
	private String approverId;

	private Timestamp createdDate;

	private String createdBy;

	private Timestamp updatedDate;

	private String updatedBy;

	private boolean isDeleted;
	
	
}

