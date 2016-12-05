package com.tobycaulk.unison.service.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tobycaulk.unison.da.mongo.account.model.AccountMongoModel;
import com.tobycaulk.unison.da.mongo.account.repository.AccountRepository;

@Service
public class AccountSessionServiceImpl implements AccountSessionService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Scheduled(fixedDelay=5000)
	public void cleanupStaleSessions() {
		Query findByAccountSessionListNotEmpty = new Query();
		findByAccountSessionListNotEmpty.addCriteria(Criteria.where("sessions.1").exists(true));
		
		List<AccountMongoModel> accountModelList = accountRepository.findAll();
	}
}
