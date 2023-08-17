package com.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
	
	public void run() {
		try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackage().getName())){
			HelloWorldService service = context.getBean(HelloWorldService.class);
			service.helloWorld();
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
