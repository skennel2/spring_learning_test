package org.almansa.springtest.core.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * https://blog.outsider.ne.kr/825
 * 
 * @author skennel
 *
 */
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> classType) {
        return Person.class.equals(classType);
    }

    @Override
    public void validate(Object obj, Errors e) {
    }

}
