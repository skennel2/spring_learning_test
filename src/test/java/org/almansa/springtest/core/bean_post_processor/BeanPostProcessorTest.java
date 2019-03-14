package org.almansa.springtest.core.bean_post_processor;

import org.almansa.springtest.testobject.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorTest {
    @Test
    public void beanPostProcessorTest() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan(this.getClass().getPackage().getName(), "org.almansa.springtest.testobject");
            context.refresh(); // refresh 안하면 IllegalStateException을 던진다.

            HelloWorldService service = context.getBean(HelloWorldService.class);
            service.hello();
        }
    }
}
