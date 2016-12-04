package com.tobycaulk.unison.validation.account;

import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.response.account.AccountCreateResponse;

public interface AccountControllerValidationService {

	public void validateAccountCreateRequest(AccountCreateRequest request) throws UException;
	public void validateAccountCreateResponse(AccountCreateResponse response) throws UException;
	
}
