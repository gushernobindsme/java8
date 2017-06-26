package com.inmotion.chapter5;

import org.junit.Test;

import java.time.LocalTime;

/**
 * {@link LocalTimeSample}のテスト。
 */
public class LocalTimeSampleTest {

    LocalTimeSample target = new LocalTimeSample();

    @Test
    public void testGetRightNow() throws Exception {
        LocalTime actual = target.getRightNow();
        System.out.println(actual);
    }

    @Test
    public void testGetBedTime() throws Exception {
        LocalTime actual = target.getBedTime();
        System.out.println(actual);
    }

    @Test
    public void testGetWakeupTime() throws Exception {
        LocalTime actual = target.getWakeupTime();
        System.out.println(actual);
    }

}
