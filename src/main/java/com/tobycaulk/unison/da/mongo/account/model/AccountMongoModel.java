package com.tobycaulk.unison.da.mongo.account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class AccountMongoModel {
	
	@Id
	private String id;
	private String accountId;
	private String aristName;
	private String email;
	private String password;
	
	public AccountMongoModel(String accountId, String aristName, String email, String password) {
		this.accountId = accountId;
		this.aristName = aristName;
		this.email = email;
		this.password = password;
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

	public String getAristName() {
		return aristName;
	}

	public void setAristName(String aristName) {
		this.aristName = aristName;
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
