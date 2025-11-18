package com.rating.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String m) {
		super(m);
	}

	public ResourceNotFoundException() {
		super("Resource not found !!");
	}

}
