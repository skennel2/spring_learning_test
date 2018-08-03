package org.almansa.springtest.testobject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.almansa.springtest"})
public class ApplicationConfig
{
	@Bean
	public HelloService helloService() {
		return new ConsolePrintHelloService();
	}
}
