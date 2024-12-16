package com.adv.empdetailsms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidEmployeeIdExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode, errorMessage;

}
