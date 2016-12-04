package com.tobycaulk.unison.service.account;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobycaulk.unison.da.mongo.account.model.AccountMongoModel;
import com.tobycaulk.unison.da.mongo.account.repository.AccountRepository;
import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.model.account.AccountSession;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.request.account.AccountLoginRequest;
import com.tobycaulk.unison.response.account.AccountCreateResponse;
import com.tobycaulk.unison.response.account.AccountCreateResponse.AccountCreateResponseCode;
import com.tobycaulk.unison.response.account.AccountLoginResponse;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountCreateResponse accountCreate(AccountCreateRequest request) throws UException {
		AccountCreateResponse response = null;
		
		boolean createStatus = false;
		AccountCreateResponseCode accountCreateResponseCode = null;
		
		if(accountRepository.findByEmail(request.getEmail()) != null) {
			accountCreateResponseCode = AccountCreateResponseCode.ACCOUNT_ALREADY_EXISTS;
		} else {
			String accountId = UUID.randomUUID().toString();
			String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt());
			AccountMongoModel accountModel = new AccountMongoModel(accountId, request.getArtistName(), request.getEmail(), hashedPassword);
			accountRepository.save(accountModel);
			
			if(accountRepository.findByEmail(request.getEmail()) == null) {
				accountCreateResponseCode = AccountCreateResponseCode.INTERNAL_ERROR_WHILE_CREATING_ACCOUNT;
			} else {
				accountCreateResponseCode = AccountCreateResponseCode.ACCOUNT_CREATED;
				createStatus = true;
			}
		}
		
		response = new AccountCreateResponse(createStatus, accountCreateResponseCode);
		
		return response;
	}

	@Override
	public AccountLoginResponse accountLogin(AccountLoginRequest request) throws UException {
		AccountLoginResponse response = null;
		
		String accountSessionId = "";

		AccountMongoModel accountModel = accountRepository.findByEmail(request.getEmail());
		if(accountModel != null) {
			if(BCrypt.checkpw(request.getPassword(), accountModel.getPassword())) {
				accountSessionId = UUID.randomUUID().toString();
				AccountSession accountSession = new AccountSession(accountSessionId);
				accountModel.addSession(accountSession);
				accountRepository.save(accountModel);
			}
		}

		response = new AccountLoginResponse(accountSessionId);
		
		return response;
	}
}
