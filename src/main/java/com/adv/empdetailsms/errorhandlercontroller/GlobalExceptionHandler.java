package com.adv.empdetailsms.errorhandlercontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adv.empdetailsms.dto.ErrorDto;
import com.adv.empdetailsms.exceptions.DataNotFoundException;
import com.adv.empdetailsms.exceptions.InvalidDataException;
import com.adv.empdetailsms.exceptions.InvalidEmployeeIdExecption;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = InvalidEmployeeIdExecption.class)
	public ResponseEntity<ErrorDto> handleInvalidEmployeeIdExecption(
			InvalidEmployeeIdExecption invalidEmployeeIdExecption) {
		String errCode = invalidEmployeeIdExecption.getErrorCode();
		String errMessage = invalidEmployeeIdExecption.getErrorMessage();
		ErrorDto errorMessageDto = new ErrorDto(errCode, errMessage);
		return new ResponseEntity<ErrorDto>(errorMessageDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidDataException.class)
	public ResponseEntity<ErrorDto> handleInvalidDataException(InvalidDataException invalidDataError) {
		String errCode = invalidDataError.getErrorCode();
		String errMessage = invalidDataError.getErrorMessage();
		ErrorDto errorMessageDto = new ErrorDto(errCode, errMessage);
		return new ResponseEntity<ErrorDto>(errorMessageDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<ErrorDto> handleDataNotFoundException(DataNotFoundException foundException) {
		String errCode = foundException.getErrorCode();
		String errMessage = foundException.getErrorMessage();
		ErrorDto errorMessageDto = new ErrorDto(errCode, errMessage);
		return new ResponseEntity<ErrorDto>(errorMessageDto, HttpStatus.BAD_REQUEST);
	}
}
