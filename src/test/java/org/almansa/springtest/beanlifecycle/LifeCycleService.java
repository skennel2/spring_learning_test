package org.almansa.springtest.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class LifeCycleService {
	
	public LifeCycleService() {
		System.out.println("Construntor was called");
	}
	
	/**
	 * 빈 생성시 생성자 호출 후에 호출될것이다. 
	 * 접근제어자가 private 이어도 상관없다. 
	 */
	@PostConstruct
	private void Initialize() {
		System.out.println("LifeCycleService Initialize");
	}
	
	/**
	 * 빈이 소멸되기 전에 호출될것이다.
	 * 접근제어자가 private 이어도 상관없다. 
	 */	
	@PreDestroy
	private void destroy() {
		System.out.println("LifeCycleService Destroy");
	}
}
