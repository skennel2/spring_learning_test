package org.almansa.springtest.testobject;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrintHelloWorldService implements HelloWorldService {

    @Override
    public void hello() {
        System.out.println("Hello");
    }
}
