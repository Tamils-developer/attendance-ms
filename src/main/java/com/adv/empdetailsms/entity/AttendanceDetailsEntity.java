package com.adv.empdetailsms.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "attendance_details")
@NamedStoredProcedureQuery(name = "AttendanceDetailsEntity.updateAttendanceAndCompOffDetails", procedureName = "update_attendance_and_compoff_details_proc", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "attendId", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "approverId", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "empId", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "updatedStatus", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "isUpdateSuccess", type = Boolean.class),
		})
public class AttendanceDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String empId;

	@Column(name = "att_date")
	private LocalDate date;

	private String shiftId;

	private String attendance;

	private String status;

	private String approverId;

	private Timestamp createdDate;

	private String createdBy;

	private Timestamp updatedDate;

	private String updatedBy;

	private boolean isDeleted;
}
