package org.almansa.springtest.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

public class CollectionUtilTest {

	@Test
	public void collectionUtilIsEmptyTest() {
		List<String> list = Arrays.asList("111", "222", "333");
		assertEquals(false, CollectionUtils.isEmpty(list));

		list = Arrays.asList();
		assertEquals(true, CollectionUtils.isEmpty(list));

		list = null;
		assertEquals(true, CollectionUtils.isEmpty(list));
	}

	@Test
	public void collectionUtilContainsTest() {
		List<String> list = Arrays.asList("111", "222", "333");

		boolean result = CollectionUtils.contains(list.iterator(), "111");

		assertEquals(result, true);

		result = CollectionUtils.contains(list.iterator(), "aaa");

		assertEquals(result, false);
	}

	/*
	 * hasUniqueObject는 컬렉션에 하나의 유일한 오브젝트만 포함하고 있는지 여부를 리턴한다.
	 */
	@Test
	public void collectionUtilHasUniqueObjectTest() {
		List<String> list = Arrays.asList("111");

		boolean result = CollectionUtils.hasUniqueObject(list);

		assertEquals(result, true);

		list = Arrays.asList();

		result = CollectionUtils.hasUniqueObject(list);

		assertEquals(result, false);

		list = Arrays.asList("111", "222", "333");

		result = CollectionUtils.hasUniqueObject(list);

		assertEquals(result, false);
	}
}
