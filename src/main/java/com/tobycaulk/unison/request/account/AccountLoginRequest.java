package com.tobycaulk.unison.request.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.request.BaseRequest;

//ONLY for logging in with U&P
//Account/Authenticate will be for authenticating via an existing sessionId
public class AccountLoginRequest extends BaseRequest {

	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("Password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
