package org.almansa.springtest.core.beanpostprocessor;

import org.almansa.springtest.testobject.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorTest {
    @Test
    public void test() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("org.almansa.springtest.beanpostprocessor", "org.almansa.springtest.testobject");
            context.refresh(); // refresh 안하면 IllegalStateException을 던진다.

            HelloService service = context.getBean(HelloService.class);
            service.hello();
        }
    }
}
