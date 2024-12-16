package com.adv.empdetailsms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftDetailsDto {

	private int id;

	private String type;

	private String timing;
}
