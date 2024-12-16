package com.adv.empdetailsms.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "createdDate", "createdBy", "updatedBy", "updatedDate", "isDeleted" })
public class RoosterDto {

	private int id;

	private LocalDate startDate;

	private LocalDate endDate;

	private LocalDate weekOffOne;

	private LocalDate weekOffTwo;

	private String shiftId;

	private String empId;

	private Timestamp createdDate;

	private String createdBy;

	private Timestamp updatedDate;

	private String updatedBy;

	private boolean isDeleted;
}
