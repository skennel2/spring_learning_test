package org.almansa.springtest.core.beanlifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class LifeCycleTest {
	@Test
	public void applicationContextGetBeanUsingBasePackageTest() {
		LifeCycleService service = null;
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.almansa.springtest.core.beanlifecycle")) {
			service = context.getBean(LifeCycleService.class);
			assertEquals("Initialize", service.getStatus());
		}

		// @PreDestroy는 ApplicationContex의 close가 호출된 후에 실행되는 것을 확인할 수 있다.
		assertEquals("destroy", service.getStatus());
	}

}
