package com.portal.web.service.impl;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.web.service.AuthService;
import com.portal.web.util.ApiKey;
import com.portal.web.util.MD5;
@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	ApiKey key;
	
	@Autowired
	HttpServletRequest request;

	@Override
	public boolean isAuth() {
		
		return Objects.equals(key.getKey(), MD5.getHash(request.getHeader("key")));
	}

	
}
