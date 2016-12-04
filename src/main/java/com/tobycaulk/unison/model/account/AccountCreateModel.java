package com.tobycaulk.unison.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountCreateModel {

	@JsonProperty("ArtistName")
	private String artistName;

	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("Password")
	private String password;

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

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
