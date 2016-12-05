package com.tobycaulk.unison.da.mongo.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tobycaulk.unison.da.mongo.account.model.AccountMongoModel;

public interface AccountRepository extends MongoRepository<AccountMongoModel, String> {
	
	public AccountMongoModel findByEmail(String email);
	
	public AccountMongoModel findByAccountId(String accountId);
	
}
