package com.bfsi.mfi.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(method = RequestMethod.POST)
public interface Assembler {
	
	User buildSpringUserFromUserAccount(com.bfsi.mfi.entity.User userAccount);
}