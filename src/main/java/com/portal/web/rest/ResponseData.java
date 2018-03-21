package com.portal.web.rest;


import org.springframework.stereotype.Service;


import com.fasterxml.jackson.annotation.JsonProperty;
@Service
public class ResponseData<T> {
	
	@JsonProperty("statusCode")
	private String statusCode;
	



	@JsonProperty("data")
	private T data;
	


	public ResponseData()
	{
		
	}


	public String getStatusCode() {
		return statusCode;
	}

	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
	public T getData() {
		return data;
	}
	

	public void setData(T data) {
		this.data = data;
	}
	


}
