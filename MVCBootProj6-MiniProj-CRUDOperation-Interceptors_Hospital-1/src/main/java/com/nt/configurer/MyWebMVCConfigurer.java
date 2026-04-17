package com.nt.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TimeCheckInterceptor;
@Component
public class MyWebMVCConfigurer implements WebMvcConfigurer {
	@Autowired
	private TimeCheckInterceptor tci;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tci);
	}
}
