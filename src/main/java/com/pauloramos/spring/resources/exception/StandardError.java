package com.pauloramos.spring.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
private Integer status;
   private String msg;
   private Long timespan;
public StandardError(Integer status, String msg, Long timespan) {
	super();
	this.status = status;
	this.msg = msg;
	this.timespan = timespan;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Long getTimespan() {
	return timespan;
}
public void setTimespan(Long timespan) {
	this.timespan = timespan;
}
   
   
}
