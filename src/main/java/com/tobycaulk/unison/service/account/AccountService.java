package com.tobycaulk.unison.service.account;

import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.response.account.AccountCreateResponse;

public interface AccountService {

	public AccountCreateResponse accountCreate(AccountCreateRequest request) throws UException;
	
}
