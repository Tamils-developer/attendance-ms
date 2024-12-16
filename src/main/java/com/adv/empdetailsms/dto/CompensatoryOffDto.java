package com.adv.empdetailsms.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "createdDate", "createdBy", "updatedBy", "updatedDate", "isDeleted" })
public class CompensatoryOffDto {

	private String id;

	private LocalDate date;

	private String status;

	private String attendId;
	
	private String empId;

	private Timestamp createdDate;

	private String createdBy;

	private Timestamp updatedDate;

	private String updatedBy;

	private boolean isDeleted;

}
