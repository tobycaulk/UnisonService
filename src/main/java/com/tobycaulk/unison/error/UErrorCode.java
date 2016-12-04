package com.tobycaulk.unison.error;

public enum UErrorCode {

	NO_ERROR(0, ""),
	INVALID_REQUEST(1, "Invalid request"),
	INVALID_RESPONSE(2, "Invalid response"),
	UNHANDLED_EXCEPTION(3, "Unhandled exception");
	
	private int code;
	private String message;
	
	private UErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
