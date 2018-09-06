package org.almansa.springtest.test;

import org.almansa.springtest.testobject.ApplicationConfig;
import org.almansa.springtest.testobject.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class SpringTestFrameworkTest {

	@Autowired
	private HelloService helloService;

	@Autowired
	private ApplicationContext context;

	@Test
	public void serviceAutowiredTest() {
		helloService.hello();
	}

	@Test
	public void contextAutowiredTest() {
		HelloService helloServiceCalledByContext = context.getBean(HelloService.class);
		helloServiceCalledByContext.hello();
	}
}
