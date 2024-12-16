package com.adv.empdetailsms.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDetailsEntity {

	
	private String id;

	private String empId;

	private String empName;

	private String empMdn;

	private String empEmail;

	private Date dateOfJoining;

	private String empRole;

	private String empDesignation;

	private String empBaseLocation;

	private String empClientLocation;

	private Timestamp createdDate;

	private String createdBy;

	private Timestamp updatedDate;

	private String updatedBy;

	private boolean isDeleted;
}
