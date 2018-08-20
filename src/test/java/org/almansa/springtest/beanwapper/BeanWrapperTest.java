package org.almansa.springtest.beanwapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/*
 * 직접적으로 사용하는  경우는 드물며 BeanFactory 및 DataBinder에서 사용된다.
 * 
 */
public class BeanWrapperTest {
	@Test
	public void BeanWrapperImpl로_동적으로_프로퍼티에_접근하기() {
		Person person = new Person();
		
		BeanWrapper personBeanWrapper = new BeanWrapperImpl(person);
		personBeanWrapper.setPropertyValue("Age", 31);
		int age = (int)personBeanWrapper.getPropertyValue("Age");
		
		assertEquals(31, age);
		assertEquals(31, person.getAge());
	}
}
