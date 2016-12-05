package com.tobycaulk.unison.da.mongo.account.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tobycaulk.unison.model.account.AccountSession;

@Document(collection = "account")
public class AccountMongoModel {
	
	@Id
	private String id;
	private String accountId;
	private String email;
	private String password;
	private List<AccountSession> sessions = new ArrayList<>();
	
	public AccountMongoModel(String accountId, String email, String password) {
		this.accountId = accountId;
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

	public List<AccountSession> getSessions() {
		return sessions;
	}

	public void setSessions(List<AccountSession> sessions) {
		this.sessions = sessions;
	}
	
	public void addSession(AccountSession session) {
		sessions.add(session);
	}
}
