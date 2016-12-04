package com.tobycaulk.unison.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.error.UError;

public class GenericErrorResponse extends BaseResponse {

	@JsonProperty("Error")
	private UError error;
	
	public GenericErrorResponse(UError error) {
		this.error = error;
	}
}
