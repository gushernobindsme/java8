package com.inmotion.chapter6;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class AtomicValueTest {

    AtomicValue target = new AtomicValue();

    @Test
    public void testAdd() throws Exception {
        long expected = 15;
        long actual = target.add(new long[]{1, 2, 3, 4, 5});

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAccumulate() throws Exception {
        long expected = 15;
        long actual = target.accumulate(new long[]{1, 2, 3, 4, 5});

        Assert.assertEquals(expected, actual);
    }

}
