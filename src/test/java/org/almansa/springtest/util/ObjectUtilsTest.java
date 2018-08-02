package org.almansa.springtest.util;

import static org.junit.Assert.assertEquals;

import org.almansa.springtest.testobject.Car;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

public class ObjectUtilsTest {
	@Test
	public void identityToStringTest() 
	{
		String hi = "hi";
		
		//오브젝트의 완전한 식별 정보의 String 표현을 리턴합니다.
		String identity1 = ObjectUtils.identityToString(hi);
		String identity2 = ObjectUtils.identityToString(hi);
		String identity3 = ObjectUtils.identityToString("Hello");

		assertEquals(true, identity1.equals(identity2));
		assertEquals(false, identity1.equals(identity3));
	}
	
	@Test
	public void nullsafeToStringTest() 
	{
		Car car = new Car();
		car.setName("Beamer 520d");
		
		Car nullCar = null;
		
		// NullPointerException에 안전한 toString 호출
		String carToString = ObjectUtils.nullSafeToString(car);
		String nullCarToString = ObjectUtils.nullSafeToString(nullCar);
		
		assertEquals(true, carToString.equals(car.toString()));
		assertEquals(true, nullCarToString.equals("null"));		
	}
	
	@Test
	public void isCheckedExceptionTest() 
	{
		// 체크예외인지 언체크예외인지 여부를 리턴한다.
		boolean checkedException = ObjectUtils.isCheckedException(new Exception());
		boolean unCheckedException = ObjectUtils.isCheckedException(new RuntimeException());
		
		assertEquals(true, checkedException);
		assertEquals(false, unCheckedException);
	}
	
	@Test
	public void isEmptyTest() 
	{
		Car car = new Car();
		//car.setName("Beamer 520d");
		
		boolean isEmpty = ObjectUtils.isEmpty(car);
		
		assertEquals(false, isEmpty);
	}	
}
