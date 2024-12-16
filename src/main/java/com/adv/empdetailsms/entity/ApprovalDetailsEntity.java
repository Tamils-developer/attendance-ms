package com.adv.empdetailsms.entity;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApprovalDetailsEntity {

	public ApprovalDetailsEntity(String id, LocalDate attDate, String attendance, int weekNumber, String status,
			String approverId, String empId) {
		this.id = id;
		this.attDate = attDate;
		this.attendance = attendance;
		this.weekNumber = weekNumber;
		this.status = status;
		this.approverId = approverId;
		this.empId = empId;
	}

	private String id;

	private LocalDate attDate;

	private String attendance;

	private int weekNumber;

	private String status;

	private String approverId;

	private String empId;

}
