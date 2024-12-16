package com.adv.empdetailsms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="shift_details")
public class ShiftDetailsEntity {

	
	@Id
	private int id;
	
	private String type;
	
	private String timing;
}
