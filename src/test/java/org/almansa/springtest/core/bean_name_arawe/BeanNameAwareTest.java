package org.almansa.springtest.core.bean_name_arawe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class BeanNameAwareTest {
	@Test
	public void beanNameAware_동작테스트() {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackage().getName())) {
			NamedBean bean = (NamedBean) context.getBean("Named Bean");
			assertEquals("Named Bean", bean.getBeanName());
		}
	}
}
