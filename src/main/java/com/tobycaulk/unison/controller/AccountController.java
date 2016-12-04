package com.tobycaulk.unison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tobycaulk.unison.error.UError;
import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.response.BaseResponse;
import com.tobycaulk.unison.response.GenericErrorResponse;
import com.tobycaulk.unison.response.account.AccountCreateResponse;
import com.tobycaulk.unison.service.account.AccountServiceImpl;
import com.tobycaulk.unison.validation.account.AccountControllerValidationServiceImpl;

@Controller
@RequestMapping("/Account")
public class AccountController {

	@Autowired
	private AccountControllerValidationServiceImpl controllerValidationService;
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@RequestMapping(value="/Create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponse create(@RequestBody AccountCreateRequest request) {
		BaseResponse response = null;
		
		try {
			controllerValidationService.validateAccountCreateRequest(request);
			response = accountService.accountCreate(request);
			controllerValidationService.validateAccountCreateResponse((AccountCreateResponse) response);
		} catch(UException e) { 
			response = new GenericErrorResponse(e.getError());
		} catch(Exception e) {
			response = new GenericErrorResponse(UError.UNHANDLED_EXCEPTION);
		}
		
		return response;
	}
}
