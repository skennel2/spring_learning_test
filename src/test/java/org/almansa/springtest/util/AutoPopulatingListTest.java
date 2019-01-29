package org.almansa.springtest.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.util.AutoPopulatingList;

public class AutoPopulatingListTest {

	@Test
	public void AutoPopulatingList_특징() {		
		// AutoPopulatingList에게 주어지는 백킹리스트는 add() 메소드가 지원해야 정상 동작한다. 
		// 반면 AutoPopulatingList는 add() 메소드를 지원하지 않는다.
		// 생성자로 백킹리스트와 ElementFactory의 구현체를 던져야하는데, ElementFactory를 특정해주지 않으면
		// 내부적으로 private static 클래스인 ReflectiveElementFactory를 이용하게된다. 
		AutoPopulatingList<String> autoPopulationList 
			= new AutoPopulatingList<>(new ArrayList<String>(Arrays.asList("1", "2", "3")), String.class);
		
		assertEquals(3, autoPopulationList.size());
		
		// 기존의 리스트라면 OutOfIndexException
		autoPopulationList.get(4);				
		
		// 자동으로 사이즈가 늘어났다.
		assertEquals(4, autoPopulationList.size());
	}
}
