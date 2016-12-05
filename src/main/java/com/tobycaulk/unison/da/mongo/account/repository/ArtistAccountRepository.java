package com.tobycaulk.unison.da.mongo.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tobycaulk.unison.da.mongo.account.model.AccountArtistMongoModel;

public interface ArtistAccountRepository extends MongoRepository<AccountArtistMongoModel, String> {

	public AccountArtistMongoModel findByAccountId(String accountId);
	
}
