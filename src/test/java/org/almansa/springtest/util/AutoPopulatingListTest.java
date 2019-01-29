package org.almansa.springtest.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.util.AutoPopulatingList;
import org.springframework.util.AutoPopulatingList.ElementFactory;
import org.springframework.util.AutoPopulatingList.ElementInstantiationException;

public class AutoPopulatingListTest {

	@Test
	public void AutoPopulatingList_특징() {
		// AutoPopulatingList에게 주어지는 백킹리스트는 add() 메소드가 지원해야 정상 동작한다.
		// 반면 AutoPopulatingList는 add() 메소드를 지원하지 않는다.
		// 생성자로 백킹리스트와 ElementFactory의 구현체를 던져야하는데, ElementFactory를 특정해주지 않으면
		// 내부적으로 private static 클래스인 ReflectiveElementFactory를 이용하게된다.
		AutoPopulatingList<String> autoPopulationList = new AutoPopulatingList<>(
				new ArrayList<String>(Arrays.asList("1", "2", "3")), String.class);

		assertEquals(3, autoPopulationList.size());

		// 기존의 리스트라면 OutOfIndexException
		autoPopulationList.get(3);

		// 자동으로 사이즈가 늘어났다.
		assertEquals(4, autoPopulationList.size());
	}

	@Test
	public void AutoPopulatingList_ElementFactory구현체로_인덱스에_따른_객체생성방법알려주기() {
		AutoPopulatingList<Integer> autoPopulationList = new AutoPopulatingList<>(
				new ArrayList<Integer>(Arrays.asList(0, 2, 4)), new MultiplyNumberElementFactory());
		
		Integer get4 = autoPopulationList.get(4);
		
		// MultiplyNumberElementFactory createElement 전략에 따른 객체가 생성되었다.
		assertEquals(8, get4.intValue());
	}

	private class MultiplyNumberElementFactory implements ElementFactory<Integer>{
		@Override
		public Integer createElement(int index) throws ElementInstantiationException {			
			return new Integer(index * 2);
		}
		
	}
}
