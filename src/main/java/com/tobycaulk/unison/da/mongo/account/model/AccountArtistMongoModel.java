package com.tobycaulk.unison.da.mongo.account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="artistAccount")
public class AccountArtistMongoModel {

	@Id
	private String id;
	private String accountId;
	private String artistName;
	private String artistBiography;
	
	public AccountArtistMongoModel(String accountId, String artistName, String artistBiography) {
		this.accountId = accountId;
		this.artistName = artistName;
		this.artistBiography = artistBiography;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
