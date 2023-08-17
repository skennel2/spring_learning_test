package org.almansa.springtest.core.bean_lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class LifeCycleTest {
	@Test
	public void applicationContextGetBeanUsingBasePackageTest() {
		LifeCycleService service = null;
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackage().getName())) {
			
			
			service = context.getBean(LifeCycleService.class);
			assertEquals("PostConstruct", service.getStatus());
		}

		// @PreDestroy는 ApplicationContex의 close가 호출된 후에 실행되는 것을 확인할 수 있다.
		assertEquals("PreDestroy", service.getStatus());
	}

}
