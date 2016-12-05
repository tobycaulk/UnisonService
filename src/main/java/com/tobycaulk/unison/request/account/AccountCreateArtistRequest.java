package com.tobycaulk.unison.request.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobycaulk.unison.request.BaseRequest;

public class AccountCreateArtistRequest extends BaseRequest {

	@JsonProperty("AccountId")
	private String accountId;
	
	@JsonProperty("ArtistName")
	private String artistName;
	
	@JsonProperty("ArtistBiography")
	private String artistBiography;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistBiography() {
		return artistBiography;
	}

	public void setArtistBiography(String artistBiography) {
		this.artistBiography = artistBiography;
	}
}
