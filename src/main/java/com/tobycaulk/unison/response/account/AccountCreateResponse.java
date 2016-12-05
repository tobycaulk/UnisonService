package com.tobycaulk.unison.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.response.BaseResponse;

public class AccountCreateResponse extends BaseResponse {

	public enum AccountCreateResponseCode {
		ACCOUNT_ALREADY_EXISTS,
		ACCOUNT_CREATED,
		INTERNAL_ERROR_WHILE_CREATING_ACCOUNT
	}
	
	@JsonProperty("CreateCode")
	private AccountCreateResponseCode accountCreateResponseCode;
	
	@JsonProperty("AccountId")
	private String accountId;
	
	public AccountCreateResponse(AccountCreateResponseCode accountCreateResponseCode, String accountId) {
		this.accountCreateResponseCode = accountCreateResponseCode;
		this.accountId = accountId;
	}
	
	public AccountCreateResponseCode getAccountCreateResponseCode() {
		return accountCreateResponseCode;
	}

	public void setAccountCreateResponseCode(AccountCreateResponseCode accountCreateResponseCode) {
		this.accountCreateResponseCode = accountCreateResponseCode;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
