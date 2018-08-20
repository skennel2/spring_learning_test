package org.almansa.springtest.bean.databinder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

public class DataBinderTest {

	@Test
	public void DataBinder로_프로퍼티정보를_빈에_바인딩() {
		MutablePropertyValues pv = new MutablePropertyValues();
		pv.add("age", 31);
		pv.add("name", "Na Yun Su");
		
		Person person = new Person();
		DataBinder db = new DataBinder(person);
		db.bind(pv);
		
		assertEquals(31, person.getAge());
		assertEquals("Na Yun Su", person.getName());
	}	

	@Test
	public void DataBinder_허용_비허용_필드_설정하기() {
		MutablePropertyValues pv = new MutablePropertyValues();
		pv.add("age", 31);
		pv.add("name", "Na Yun Su");
		
		Person person = new Person();
		DataBinder db = new DataBinder(person);
		//db.setAllowedFields("age");
		db.setDisallowedFields("name");
		
		db.bind(pv);
		
		assertEquals(31, person.getAge());
		assertEquals(null, person.getName());
	}
}
