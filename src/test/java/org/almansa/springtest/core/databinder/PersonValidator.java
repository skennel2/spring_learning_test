package org.almansa.springtest.core.databinder;

import org.springframework.util.ObjectUtils;
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
    	Person person = (Person)obj;
    	
    	if(ObjectUtils.isEmpty(person.getName())) {
    		e.rejectValue("name", "name.empty");
    	}
    }
}
