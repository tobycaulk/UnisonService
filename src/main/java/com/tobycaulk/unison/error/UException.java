package com.tobycaulk.unison.error;

public class UException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UError error;
	
	public UException(UError error) {
		super(error.getMessage());
		
		this.error = error;
	}
	
	public UException(UError error, Throwable t) {
		super(error.getMessage(), t);
		
		this.error = error;
	}
	
	public UError getError() {
		return error;
	}
	
	public void setError(UError error) {
		this.error = error;
	}
}
