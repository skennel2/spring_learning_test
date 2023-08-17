package com.practice;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService implements InitializingBean, DisposableBean {
	
	public HelloWorldService() {
		System.out.println("HelloWorldService constructor");
	}
	
	public void helloWorld() {
		System.out.println("Hello World");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}
}
