package com.tobycaulk.unison.service.account;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobycaulk.unison.da.mongo.account.model.AccountArtistMongoModel;
import com.tobycaulk.unison.da.mongo.account.model.AccountMongoModel;
import com.tobycaulk.unison.da.mongo.account.repository.AccountRepository;
import com.tobycaulk.unison.da.mongo.account.repository.ArtistAccountRepository;
import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.model.account.AccountSession;
import com.tobycaulk.unison.request.account.AccountCreateArtistRequest;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.request.account.AccountLoginRequest;
import com.tobycaulk.unison.response.account.AccountCreateArtistResponse;
import com.tobycaulk.unison.response.account.AccountCreateArtistResponse.AccountCreateArtistResponseCode;
import com.tobycaulk.unison.response.account.AccountCreateResponse;
import com.tobycaulk.unison.response.account.AccountCreateResponse.AccountCreateResponseCode;
import com.tobycaulk.unison.response.account.AccountLoginResponse;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ArtistAccountRepository artistAccountRepository;
	
	@Override
	public AccountCreateResponse accountCreate(AccountCreateRequest request) throws UException {
		AccountCreateResponse response = null;
		
		AccountCreateResponseCode accountCreateResponseCode = null;
		String accountId = "";
		
		if(accountRepository.findByEmail(request.getEmail()) != null) {
			accountCreateResponseCode = AccountCreateResponseCode.ACCOUNT_ALREADY_EXISTS;
		} else {
			accountId = UUID.randomUUID().toString();
			String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt());
			AccountMongoModel accountModel = new AccountMongoModel(accountId, request.getEmail(), hashedPassword);
			accountRepository.save(accountModel);
			
			if(accountRepository.findByEmail(request.getEmail()) == null) {
				accountCreateResponseCode = AccountCreateResponseCode.INTERNAL_ERROR_WHILE_CREATING_ACCOUNT;
			} else {
				accountCreateResponseCode = AccountCreateResponseCode.ACCOUNT_CREATED;
			}
		}
		
		response = new AccountCreateResponse(accountCreateResponseCode, accountId);
		
		return response;
	}

	@Override
	public AccountCreateArtistResponse accountCreateArtist(AccountCreateArtistRequest request) throws UException {
		AccountCreateArtistResponse response = null;
		
		AccountCreateArtistResponseCode accountCreateArtistResponseCode = null;
		String accountSessionId = "";
		
		AccountMongoModel accountModel = accountRepository.findByAccountId(request.getAccountId());
		//Check to see if regular user account doesn't exist. Regular account must exist to attach artist data to
		if(accountModel == null) {
			accountCreateArtistResponseCode = AccountCreateArtistResponseCode.ACCOUNT_DOES_NOT_EXIST;
		} else {
			//Reject request if regular account already has artist data attached
			if(artistAccountRepository.findByAccountId(request.getAccountId()) != null) {
				accountCreateArtistResponseCode = AccountCreateArtistResponseCode.ARTIST_ACCOUNT_ALREADY_EXISTS;
			} else {
				//Create artist data and save to artistAccount collection
				AccountArtistMongoModel accountArtistModel = new AccountArtistMongoModel(request.getAccountId(), request.getArtistName(), request.getArtistBiography());
				artistAccountRepository.save(accountArtistModel);
	
				//Lookup newly created artist data from artistAccount collection
				if(artistAccountRepository.findByAccountId(request.getAccountId()) == null) {
					//If we can't find it, there was an internal error
					accountCreateArtistResponseCode = AccountCreateArtistResponseCode.INTERNAL_ERROR_WHILE_CREATING_ARTIST_ACCOUNT;
				} else {
					//Else, create a new session for the regular user account and return success
					accountSessionId = UUID.randomUUID().toString();
					AccountSession accountSession = new AccountSession(accountSessionId);
					accountModel.addSession(accountSession);
					accountRepository.save(accountModel);
					
					accountCreateArtistResponseCode = AccountCreateArtistResponseCode.ARTIST_ACCOUNT_CREATED;
				}
			}
		}
		
		response = new AccountCreateArtistResponse(accountCreateArtistResponseCode, accountSessionId);
		
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
