package com.nt.interceptor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component	
public class TimeCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,Object handler) throws Exception{
		System.out.println("TimeCheckInterceptor.preHandle()");
		if(!req.getServletPath().equals("/")) { // do not apply  this logic for home page
					
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		if(hour<9 || hour>=18) {
			RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		}
		return true;
	}

}
