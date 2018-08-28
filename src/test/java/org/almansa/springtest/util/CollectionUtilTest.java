package org.almansa.springtest.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

public class CollectionUtilTest {

    @Test
    public void collectionUtilTest() {
        List<String> list = Arrays.asList("111", "222", "333");
        assertEquals(false, CollectionUtils.isEmpty(list));
        
        list = Arrays.asList();
        assertEquals(true, CollectionUtils.isEmpty(list));
        
        list = null;
        assertEquals(true, CollectionUtils.isEmpty(list));
    }
}
