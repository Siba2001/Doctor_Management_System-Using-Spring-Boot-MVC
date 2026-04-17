package com.nt.error;

public class DoctorNotFoundException extends RuntimeException {
	public DoctorNotFoundException(String msg) {
		super(msg);
	}

}
