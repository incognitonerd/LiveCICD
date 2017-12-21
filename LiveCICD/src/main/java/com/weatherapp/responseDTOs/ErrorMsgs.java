package com.weatherapp.responseDTOs;
public class ErrorMsgs {
	private String errMsg = "Invalid Zip Code!";
	
	public ErrorMsgs(String errMsg){
		this.errMsg = errMsg;
	}
	
	public String getErrMsg(){
		return errMsg;
	}
}