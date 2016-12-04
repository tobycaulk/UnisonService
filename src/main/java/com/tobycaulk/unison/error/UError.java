package com.tobycaulk.unison.error;

public class UError {

	public static final UError NO_ERROR = new UError(UErrorCode.NO_ERROR);
	public static final UError INVALID_REQUEST = new UError(UErrorCode.INVALID_REQUEST);
	public static final UError INVALID_RESPONSE = new UError(UErrorCode.INVALID_RESPONSE);
	
	private UErrorCode errorCode;
	
	public UError(UErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public int getCode() {
		return errorCode.getCode();
	}
	
	public String getMessage() {
		return errorCode.getMessage();
	}
	
	public String getName() {
		return errorCode.name();
	}
}
