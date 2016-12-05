package com.tobycaulk.unison.validation.account;

import org.springframework.stereotype.Service;

import com.tobycaulk.unison.error.UError;
import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateArtistRequest;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.request.account.AccountLoginRequest;
import com.tobycaulk.unison.response.account.AccountCreateArtistResponse;
import com.tobycaulk.unison.response.account.AccountCreateArtistResponse.AccountCreateArtistResponseCode;
import com.tobycaulk.unison.response.account.AccountCreateResponse;
import com.tobycaulk.unison.response.account.AccountLoginResponse;
import com.tobycaulk.unison.util.Util;

@Service
public class AccountControllerValidationServiceImpl implements AccountControllerValidationService {

	@Override
	public void validateAccountCreateRequest(AccountCreateRequest request) throws UException {
		if(!Util.validateStringsInArray(true, request.getEmail(), request.getPassword())) {
			throw new UException(UError.INVALID_REQUEST);
		}
	}

	@Override
	public void validateAccountCreateResponse(AccountCreateResponse response) throws UException {
		if(response.getAccountCreateResponseCode() == null) {
			throw new UException(UError.INVALID_RESPONSE);
		}
	}

	@Override
	public void validateAccountLoginRequest(AccountLoginRequest request) throws UException {
		if(!Util.validateStringsInArray(true, request.getEmail(), request.getPassword())) {
			throw new UException(UError.INVALID_REQUEST);
		}
	}

	@Override
	public void validateAccountLoginResponse(AccountLoginResponse response) throws UException {
		if(!Util.validateStringsInArray(true, response.getAccountSessionId())) {
			throw new UException(UError.INVALID_RESPONSE);
		}
	}

	@Override
	public void validateAccountCreateArtistRequest(AccountCreateArtistRequest request) throws UException {
		if(!Util.validateStringsInArray(true, request.getAccountId(), request.getArtistName()) || !Util.validateStringsInArray(false, request.getArtistBiography())) {
			throw new UException(UError.INVALID_REQUEST);
		}
	}

	@Override
	public void validateAccountCreateArtistResponse(AccountCreateArtistResponse response) throws UException {
		boolean throwInvalidResponse = false;
		
		if(response.getCreateArtistCode() == null) {
			throwInvalidResponse = true;
		} else {
			if(response.getCreateArtistCode() == AccountCreateArtistResponseCode.ARTIST_ACCOUNT_CREATED && !Util.validateStringsInArray(true, response.getAccountSessionId())) {
				throwInvalidResponse = true;
			}
		}

		if(throwInvalidResponse) {
			throw new UException(UError.INVALID_RESPONSE);
		}
	}
}
