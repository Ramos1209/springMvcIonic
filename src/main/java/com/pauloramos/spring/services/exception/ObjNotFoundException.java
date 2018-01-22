package com.pauloramos.spring.services.exception;

public class ObjNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjNotFoundException(String msg,Throwable causa) {
		super(msg,causa);
	}
	
	
	
}
