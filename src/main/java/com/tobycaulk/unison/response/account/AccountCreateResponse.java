package com.tobycaulk.unison.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.response.BaseResponse;

public class AccountCreateResponse extends BaseResponse {

	@JsonProperty("CreateStatus")
	private boolean createStatus;
	
	public AccountCreateResponse(boolean createStatus) {
		this.createStatus = createStatus;
	}
	
	public boolean getCreateStatus() {
		return createStatus;
	}
	
	public void setCreateStatus(boolean createStatus) {
		this.createStatus = createStatus;
	}
}
