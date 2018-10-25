package org.almansa.springtest.util;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest {
    @Test(expected = IllegalArgumentException.class)
    public void assertIsNullTest() {
        String obj = "d";

        Assert.isNull(obj, "obj can't be non null");
    }
    
    @Test
    public void assertIsNullTestNullParameter() {
        String obj = null;

        Assert.isNull(obj, "obj can't be non null");
    }    

    @Test(expected = IllegalArgumentException.class)
    public void assertHasLengthTestEmptyParemeter() {
        String str = "";

        Assert.hasLength(str, "obj must not be empty");
    }
    
    @Test
    public void assertHasLengthTest() {
        String str = "abc";

        Assert.hasLength(str, "obj must not be empty");
    }    
}
