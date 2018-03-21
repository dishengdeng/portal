package com.portal.web.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler<T> extends ResponseEntity<T>
{

	public ResponseHandler(HttpStatus status) {
		super(status);

		
	}
	
	public ResponseHandler(T body,HttpStatus status) {
		super(body, null, status);
	}
	
}