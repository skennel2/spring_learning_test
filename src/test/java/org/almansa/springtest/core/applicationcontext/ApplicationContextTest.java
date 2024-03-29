package org.almansa.springtest.core.applicationcontext;

import org.almansa.springtest.config.ApplicationConfig;
import org.almansa.springtest.testobject.HelloWorldService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ApplicationContextTest {

    /**
     * 생성자의 base-package는 @Configurable도 포함해서 스캔한다. 때문에 HelloService의
     * 구현체는 @Component에서 파생된 어노테이션이 안붙어 있지만 Config클래스를 이용해서 정상적으로 빈으로 등록된것을 확인할 수
     * 있다.
     */
    @Test
    public void getBean으로_등록된_빈_가져오기() {

        // AutoClosable 인터페이스는 AbstractApplicationContext 레벨에서 정의되어있다.
        // ApplicationContext 레벨에는 정의되어있지 않다.
        try (AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.almansa.springtest.testobject")) {
            HelloWorldService service = context.getBean(HelloWorldService.class);
            service.hello();
        }
    }

    @Test
    public void config클래스로_스프링설정정보읽기() {

        try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            HelloWorldService service = context.getBean(HelloWorldService.class);
            service.hello();
            
        }
    }

    /**
     * FactoryBean<T> 을 구현한 클래스를 만들어 빈으로 등록하면 T타입의 인스턴스화를 직접 제어할 수 있다. 사실상은
     * FactoryBean을 이용할 경우 FactoryBean 인스턴스 자체가 하나의 Bean으로 인식되는 것이 아니라 FactoryBean의
     * getObject()를 통하여 반환되는 Object를 Bean으로 관리하는 것이 가능하게 되는 것이다.
     */
    @Test
    public void FactoryBean클래스로_빈생성_로직_추상화하기() {
        try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackage().getName())) {
            BeanWillBeMakedUsingFactoryBean bean = context.getBean(BeanWillBeMakedUsingFactoryBean.class);
            bean.doSomething();
        }
    }
}