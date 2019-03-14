package org.almansa.springtest.core.aware;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
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
	
	@Test
	public void beanFactoryAware_동작테스트() {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackage().getName())) {
			ContainBeanFactoryBean bean = context.getBean(ContainBeanFactoryBean.class);
		
			BeanFactory beanFatory = bean.getBeanFactory();
			assertEquals(true, beanFatory == context.getBeanFactory());
		}
	}
	
	@Test
	public void applicationContextAware_동작테스트() {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackage().getName())) {
			ContainContextBean bean = context.getBean(ContainContextBean.class);
		
			assertEquals(true, bean.getApplicationContext() == context);
		}
	}
}
