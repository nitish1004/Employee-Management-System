package com.employee.department.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleallException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(DepartmentAlreadyExist.class)
	public final ResponseEntity<ErrorDetails> departmentAlreadyExist(DepartmentAlreadyExist ex, WebRequest request) throws Exception {
		ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(), ex.getMsg(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(DepartmentNotFound.class)
	public final ResponseEntity<ErrorDetails> departmentNotFound(DepartmentNotFound ex, WebRequest request) throws Exception {
		ErrorDetails errordetails = new ErrorDetails(LocalDateTime.now(), ex.getMsg(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.BAD_GATEWAY);
	}

}
