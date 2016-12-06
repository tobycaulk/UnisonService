package com.tobycaulk.unison.service.session;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tobycaulk.unison.da.mongo.account.model.AccountMongoModel;
import com.tobycaulk.unison.da.mongo.account.repository.AccountRepository;
import com.tobycaulk.unison.model.account.AccountSession;

@Service
public class AccountSessionServiceImpl implements AccountSessionService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Scheduled(fixedDelay=5000)
	public void cleanupStaleSessions() {
		/*Query findByAccountSessionListNotEmpty = new Query();
		findByAccountSessionListNotEmpty.addCriteria(Criteria.where("sessions.1").exists(true));*/
		
		List<AccountMongoModel> accountModelList = accountRepository.findAll();
		for(AccountMongoModel accountModel : accountModelList) {
			for(AccountSession accountSession : accountModel.getSessions()) {
				Date sessionLastUsedDate = accountSession.getLastUsedDate();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(sessionLastUsedDate);
				calendar.add(Calendar.SECOND, 5);
				//If current time is greater than last used time + timeout, then remove the stale session
				if(new Date().getTime() > calendar.getTime().getTime()) {
				}
			}
		}
	}
}
