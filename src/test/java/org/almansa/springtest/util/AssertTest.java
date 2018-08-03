package org.almansa.springtest.util;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest {
	@Test(expected =IllegalArgumentException.class)
	public void assertIsNullTest() {
		String obj = "d";
		
		Assert.isNull(obj, "obj can't be non null");
	} 
	
	@Test(expected =IllegalArgumentException.class)
	public void assertHasLengthTest() {
		String obj = "";
		
		Assert.hasLength(obj, "obj must not be empty");	
	} 
}
