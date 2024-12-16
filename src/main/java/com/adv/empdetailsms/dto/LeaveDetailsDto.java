package com.adv.empdetailsms.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "createdDate", "createdBy", "updatedBy", "updatedDate", "isDeleted" })
public class LeaveDetailsDto {
	private int id;

	private int leaveCount;

	private int compOffCount;

	private String empId;

	private Timestamp createdDate;

	private String createdBy;

	private Timestamp updatedDate;

	private String updatedBy;

	private boolean isDeleted;
}
