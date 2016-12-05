package com.tobycaulk.unison.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.response.BaseResponse;

public class AccountCreateArtistResponse extends BaseResponse {

	public enum AccountCreateArtistResponseCode {
		ACCOUNT_DOES_NOT_EXIST,
		ARTIST_ACCOUNT_ALREADY_EXISTS,
		ARTIST_ACCOUNT_CREATED,
		INTERNAL_ERROR_WHILE_CREATING_ARTIST_ACCOUNT
	}
	
	@JsonProperty("CreateArtistCode")
	private AccountCreateArtistResponseCode createArtistCode;
	
	@JsonProperty("AccountSessionId")
	private String accountSessionId;

	public AccountCreateArtistResponse(AccountCreateArtistResponseCode createArtistCode, String accountSessionId) {
		this.createArtistCode = createArtistCode;
		this.accountSessionId = accountSessionId;
	}

	public AccountCreateArtistResponseCode getCreateArtistCode() {
		return createArtistCode;
	}

	public void setCreateArtistCode(AccountCreateArtistResponseCode createArtistCode) {
		this.createArtistCode = createArtistCode;
	}

	public String getAccountSessionId() {
		return accountSessionId;
	}

	public void setAccountSessionId(String accountSessionId) {
		this.accountSessionId = accountSessionId;
	}
}
