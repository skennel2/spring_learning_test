package org.almansa.springtest.core.bean.beanutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class BeanUtilsTest {
	@Test
	public void copyProperties로_객체복사() {
		SourceClass sourceClass = new SourceClass();
		sourceClass.setValue1("Hello");
		sourceClass.setValue2("World");

		TargetClass targetClass = new TargetClass();

		BeanUtils.copyProperties(sourceClass, targetClass);

		assertEquals(sourceClass.getValue1(), targetClass.getValue1());
		assertEquals(sourceClass.getValue2(), targetClass.getValue2());
	}

	public class SourceClass {
		private String value1;
		private String value2;

		public String getValue1() {
			return value1;
		}

		public void setValue1(String value1) {
			this.value1 = value1;
		}

		public String getValue2() {
			return value2;
		}

		public void setValue2(String value2) {
			this.value2 = value2;
		}
	}

	public class TargetClass {
		private String value1;
		private String value2;

		public String getValue1() {
			return value1;
		}

		public void setValue1(String value1) {
			this.value1 = value1;
		}

		public String getValue2() {
			return value2;
		}

		public void setValue2(String value2) {
			this.value2 = value2;
		}
	}
}