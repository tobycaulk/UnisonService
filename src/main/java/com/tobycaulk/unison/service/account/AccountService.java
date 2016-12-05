package com.tobycaulk.unison.service.account;

import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateArtistRequest;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.request.account.AccountLoginRequest;
import com.tobycaulk.unison.response.account.AccountCreateArtistResponse;
import com.tobycaulk.unison.response.account.AccountCreateResponse;
import com.tobycaulk.unison.response.account.AccountLoginResponse;

public interface AccountService {

	public AccountCreateResponse accountCreate(AccountCreateRequest request) throws UException;
	
	public AccountCreateArtistResponse accountCreateArtist(AccountCreateArtistRequest request) throws UException;
	
	public AccountLoginResponse accountLogin(AccountLoginRequest request) throws UException;
	
}
