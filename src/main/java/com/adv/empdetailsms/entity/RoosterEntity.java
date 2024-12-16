package com.adv.empdetailsms.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rooster_table")
public class RoosterEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO) f
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
