package com.tobycaulk.unison.model.account;

import java.util.Date;

public class AccountSession {

	private String sessionId;
	private Date lastUsedDate;
	
	public AccountSession(String sessionId) {
		this(sessionId, new Date());
	}

	public AccountSession(String sessionId, Date lastUsedDate) {
		this.sessionId = sessionId;
		this.lastUsedDate = lastUsedDate;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public Date getLastUsedDate() {
		return lastUsedDate;
	}
	
	public void setLastUsedDate(Date lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}
}
