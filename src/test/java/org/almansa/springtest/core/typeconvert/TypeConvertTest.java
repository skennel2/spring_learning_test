package org.almansa.springtest.core.typeconvert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.convert.converter.Converter;

public class TypeConvertTest {
    @Test
    public void usingTypeConvert() {
        try (AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.almansa.springtest.core.typeconvert")) {
        	Converter<String,Address> addressConverter = context.getBean(StringToAddressConverter.class);
        	Address address =  addressConverter.convert("this is address");
        	
        	assertEquals("this is address", address.getAddress());
        }
    }
}
