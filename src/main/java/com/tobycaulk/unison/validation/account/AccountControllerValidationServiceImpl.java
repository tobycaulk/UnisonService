package com.tobycaulk.unison.validation.account;

import com.tobycaulk.unison.error.UError;
import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.response.account.AccountCreateResponse;
import com.tobycaulk.unison.util.Util;

public class AccountControllerValidationServiceImpl implements AccountControllerValidationService {

	@Override
	public void validateAccountCreateRequest(AccountCreateRequest request) throws UException {
		if(!Util.validateStringsInArray(true, request.getArtistName(), request.getEmail(), request.getPassword())) {
			throw new UException(UError.INVALID_REQUEST);
		}
	}

	@Override
	public void validateAccountCreateResponse(AccountCreateResponse response) throws UException {
	}
}
