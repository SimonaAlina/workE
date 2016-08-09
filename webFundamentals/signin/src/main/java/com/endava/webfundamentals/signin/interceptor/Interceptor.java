package com.endava.webfundamentals.signin.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.endava.webfundamentals.signin.service.AuthenticationService;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

	@Resource(name = "${spring.bean.authentication}")
    private AuthenticationService authenticationService;
	
	//TODO
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!authenticationService.isLogged(request)) {
			return false;
		}
		return true;
	}
	
}
