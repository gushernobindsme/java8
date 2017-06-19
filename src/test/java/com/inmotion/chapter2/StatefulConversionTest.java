package com.inmotion.chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * {@link StatefulConversion}のテスト。
 */
public class StatefulConversionTest {

    StatefulConversion target = new StatefulConversion();

    @Test
    public void testDistinct() throws Exception {
        // execute
        List<String> actual = target.distinct(Arrays.asList("merrily", "merrily", "merrily", "gently"));

        // check
        Assert.assertEquals("merrily", actual.get(0));
        Assert.assertEquals("gently", actual.get(1));
    }

    @Test
    public void testLongestFirst() throws Exception {
        // execute
        List<String> actual = target.sorted(Arrays.asList("one", "five", "sixty nine"));

        // check
        Assert.assertEquals("sixty nine", actual.get(0));
        Assert.assertEquals("five", actual.get(1));
        Assert.assertEquals("one", actual.get(2));
    }

}
