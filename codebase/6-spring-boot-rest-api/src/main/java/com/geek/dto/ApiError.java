package com.geek.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApiError {
 private String msg;
 private String errorCode;
 public ApiError() {
}
public ApiError(String msg, String errorCode) {
	super();
	this.msg = msg;
	this.errorCode = errorCode;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
 
}
