package com.adv.empdetailsms.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="comp_off_details")
public class CompensatoryOffEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
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
