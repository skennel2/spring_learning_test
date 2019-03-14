package org.almansa.springtest.core.bean.bean_wapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;

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
		int age = (int) personBeanWrapper.getPropertyValue("Age");

		assertEquals(31, age);
		assertEquals(31, person.getAge());
	}

	@Test
	public void BeanWrapperImpl로_동적으로_프로퍼티에_접근하기_CaseIntensive_테스트() {
		Person person = new Person();

		BeanWrapper personBeanWrapper = new BeanWrapperImpl(person);
		personBeanWrapper.setPropertyValue("age", 31);
		int age = (int) personBeanWrapper.getPropertyValue("age");

		assertEquals(31, age);
		assertEquals(31, person.getAge());
	}

	@Test
	public void BeanWrapper_facory메소드로_구현제_가져오기() {
		Person person = new Person();

		// API 문서에서 권장하는 방식이다.
		BeanWrapper personBeanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(person);
		personBeanWrapper.setPropertyValue("age", 31);
		int age = (int) personBeanWrapper.getPropertyValue("age");

		assertEquals(31, age);
		assertEquals(31, person.getAge());
	}
}
