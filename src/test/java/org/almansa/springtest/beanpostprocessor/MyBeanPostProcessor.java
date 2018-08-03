package org.almansa.springtest.beanpostprocessor;

import org.almansa.springtest.testobject.HelloService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + " postProcessBeforeInitialization");
		
		if(bean instanceof HelloService) {
			System.out.println(beanName + " zzz");
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + " postProcessAfterInitialization");
		
		return bean;
	}

}