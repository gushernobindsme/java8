package com.inmotion.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link Timeline}のテスト。
 */
public class TimelineTest {

    Timeline target = new Timeline();

    @Test
    public void testDuration() throws Exception {
        long actual = target.duration();

        System.out.println(actual);
    }

}
