package org.almansa.springtest.typeconvert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * https://www.baeldung.com/spring-mvc-custom-data-binder
 * 
 * @author skennel
 *
 */
@Component
public class StringToAddressConverter implements Converter<String, Address> {
    @Override
    public Address convert(String arg) {
        Address address = new Address();
        address.setAddress(arg);
        return address;
    }

}
