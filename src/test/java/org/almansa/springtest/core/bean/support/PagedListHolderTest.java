package org.almansa.springtest.core.bean.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.support.PagedListHolder;

public class PagedListHolderTest {

	@Test
	public void PagedListHolder_특징() {
		List<String> source = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

		PagedListHolder<String> pagedListHolder = new PagedListHolder<>(source);
		pagedListHolder.setPageSize(2);

		pagedListHolder.nextPage();
		List<String> page = pagedListHolder.getPageList();

		assertEquals("3", page.get(0));
		assertEquals("4", page.get(1));
		
		pagedListHolder.nextPage();
		page = pagedListHolder.getPageList();

		assertEquals("5", page.get(0));	
	}
}
