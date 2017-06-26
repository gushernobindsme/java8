package com.inmotion.chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * {@link FormattingAndAnalysis}のテスト。
 */
public class FormattingAndAnalysisTest {

    FormattingAndAnalysis target = new FormattingAndAnalysis();

    @Test
    public void testStandardFormat() throws Exception {
        String actual = target.standardFormat(ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York")));
        String expect = "1969-07-16T09:32:00-04:00[America/New_York]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testLocaleSpecificFormat() throws Exception {
        String actual = target.localeSpecificFormat(ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York")));
        String expect = "1969/07/16 9:32:00 EDT";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testCustomFormat() throws Exception {
        String actual = target.customFormat(ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York")));
        String expect = "1969-07-16 09:32";
        Assert.assertEquals(expect, actual);
    }
}
