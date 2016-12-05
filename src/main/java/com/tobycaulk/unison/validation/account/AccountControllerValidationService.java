package com.tobycaulk.unison.validation.account;

import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateArtistRequest;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.request.account.AccountLoginRequest;
import com.tobycaulk.unison.response.account.AccountCreateArtistResponse;
import com.tobycaulk.unison.response.account.AccountCreateResponse;
import com.tobycaulk.unison.response.account.AccountLoginResponse;

public interface AccountControllerValidationService {

	public void validateAccountCreateRequest(AccountCreateRequest request) throws UException;
	public void validateAccountCreateResponse(AccountCreateResponse response) throws UException;
	
	public void validateAccountCreateArtistRequest(AccountCreateArtistRequest request) throws UException;
	public void validateAccountCreateArtistResponse(AccountCreateArtistResponse response) throws UException;
	
	public void validateAccountLoginRequest(AccountLoginRequest request) throws UException;
	public void validateAccountLoginResponse(AccountLoginResponse response) throws UException;
	
}
