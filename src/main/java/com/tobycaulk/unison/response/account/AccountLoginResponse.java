package com.tobycaulk.unison.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.response.BaseResponse;

public class AccountLoginResponse extends BaseResponse {
	
	@JsonProperty("AccountSessionId")
	private String accountSessionId;

	public AccountLoginResponse(String accountSessionId) {
		this.accountSessionId = accountSessionId;
	}
	
	public String getAccountSessionId() {
		return accountSessionId;
	}

	public void setAccountSessionId(String accountSessionId) {
		this.accountSessionId = accountSessionId;
	}
}
