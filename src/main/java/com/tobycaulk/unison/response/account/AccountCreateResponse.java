package com.tobycaulk.unison.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.response.BaseResponse;

public class AccountCreateResponse extends BaseResponse {

	public enum AccountCreateResponseCode {
		ACCOUNT_ALREADY_EXISTS,
		ACCOUNT_CREATED,
		INTERNAL_ERROR_WHILE_CREATING_ACCOUNT
	}
	
	@JsonProperty("CreateStatus")
	private boolean createStatus;
	
	@JsonProperty("CreateCode")
	private AccountCreateResponseCode accountCreateResponseCode;
	
	public AccountCreateResponse(boolean createStatus, AccountCreateResponseCode accountCreateResponseCode) {
		this.createStatus = createStatus;
		this.accountCreateResponseCode = accountCreateResponseCode;
	}
	
	public boolean getCreateStatus() {
		return createStatus;
	}
	
	public void setCreateStatus(boolean createStatus) {
		this.createStatus = createStatus;
	}

	public AccountCreateResponseCode getAccountCreateResponseCode() {
		return accountCreateResponseCode;
	}

	public void setAccountCreateResponseCode(AccountCreateResponseCode accountCreateResponseCode) {
		this.accountCreateResponseCode = accountCreateResponseCode;
	}
}
