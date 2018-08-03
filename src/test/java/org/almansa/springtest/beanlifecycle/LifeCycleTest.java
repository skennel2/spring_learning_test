package org.almansa.springtest.beanlifecycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class LifeCycleTest {
	@Test
	public void applicationContextGetBeanUsingBasePackageTest() {
		try(AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.almansa.springtest.beanlifecycle"))
		{
			LifeCycleService service = context.getBean(LifeCycleService.class);			
			service.toString();
		}
	}

}
