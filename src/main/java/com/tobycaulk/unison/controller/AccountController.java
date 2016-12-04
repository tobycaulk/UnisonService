package com.tobycaulk.unison.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tobycaulk.unison.error.UException;
import com.tobycaulk.unison.request.account.AccountCreateRequest;
import com.tobycaulk.unison.response.BaseResponse;
import com.tobycaulk.unison.response.GenericErrorResponse;

@Controller
@RequestMapping("/Account")
public class AccountController {

	@RequestMapping(value="/Create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponse create(@RequestBody AccountCreateRequest request) {
		BaseResponse response = null;
		
		try {
			
		} catch(UException e) {
			response = new GenericErrorResponse(e.getError());
		} catch(Exception e) {
			
		}
		
		return response;
	}
}
