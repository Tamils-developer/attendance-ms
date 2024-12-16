package com.adv.empdetailsms.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "leave_details")
public class LeaveDetailsEntity {

	@Id
	private int id;

	@Column(name = "leave_count")
	private int leaveCount;

	@Column(name = "comp_off_count")
	private int compOffCount;

	private String empId;

	private Timestamp createdDate;

	private String createdBy;

	private Timestamp updatedDate;

	private String updatedBy;

	private boolean isDeleted;

}
