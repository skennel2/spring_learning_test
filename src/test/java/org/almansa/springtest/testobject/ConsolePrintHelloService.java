package org.almansa.springtest.testobject;

public class ConsolePrintHelloService implements HelloService {

	@Override
	public void hello() {		
		System.out.println("Hello");
	}

}
