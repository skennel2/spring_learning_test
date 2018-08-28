package org.almansa.springtest.util;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.almansa.springtest.testobject.Car;
import org.junit.jupiter.api.Test;
import org.springframework.util.MethodInvoker;

public class MethodInvokerTest {
    @Test
    public void methodInvokerTest()
            throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException {
        Car car = new Car();
        car.setName("Beamer 520d");

        MethodInvoker invoker = new MethodInvoker();
        invoker.setTargetClass(Car.class);
        invoker.setTargetObject(car);
        invoker.setTargetMethod("setName");
        invoker.setArguments("Sonata");

        // invoke 전에 prepare를 호출해주지 않으면 예외를 던진다.
        invoker.prepare();
        invoker.invoke();

        assertEquals("Sonata", car.getName());
    }
}
