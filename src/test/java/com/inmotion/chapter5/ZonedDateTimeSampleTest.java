package com.inmotion.chapter5;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * {@link ZonedDateTimeSample}のテスト。
 */
public class ZonedDateTimeSampleTest {

    ZonedDateTimeSample target = new ZonedDateTimeSample();

    @Test
    public void testGetApollo11launch() throws Exception {
        ZonedDateTime actual = target.getApollo11launch();
        System.out.println(actual);
    }

    @Test
    public void testSkipped() throws Exception {
        ZonedDateTime actual = target.skipped();
        System.out.println(actual);
    }

    @Test
    public void testAmbiguous() throws Exception {
        ZonedDateTime actual = target.ambiguous();
        System.out.println(actual);
    }

    @Test
    public void testNextMeeting() throws Exception {
        ZonedDateTime actual = target.nextMeeting(ZonedDateTime.now());
        System.out.println(actual);
    }

}
