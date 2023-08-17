package org.almansa.springtest.config;

import org.almansa.springtest.testobject.ConsolePrintHelloWorldService;
import org.almansa.springtest.testobject.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.almansa.springtest.testobject" })
public class ApplicationConfig {

}
