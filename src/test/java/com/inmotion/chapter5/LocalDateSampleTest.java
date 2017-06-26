package com.inmotion.chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

/**
 * {@link LocalDateSample}
 */
public class LocalDateSampleTest {

    LocalDateSample target = new LocalDateSample();

    @Test
    public void testGetToday() throws Exception {
        LocalDate actual = target.getToday();
        System.out.println(actual);
    }

    @Test
    public void testGetAlonzosBirthday() throws Exception {
        LocalDate actual = target.getAlonzosBirthday();
        System.out.println(actual);
    }

    @Test
    public void testGetNextProgrammersDay() throws Exception {
        LocalDate actual = target.getNextProgrammersDay(LocalDate.now());
        System.out.println(actual);
    }

    @Test
    public void testUntil() throws Exception {
        Period actual = target.until(LocalDate.of(2017,5,8), LocalDate.of(2017,5,30));
        Period expected = Period.ofDays(22);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUntilDays() throws Exception {
        long actual = target.untilDays(LocalDate.of(2017,5,8), LocalDate.of(2017,5,30));
        long expected = 22;
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetThreeDaysAgo() throws Exception {
        DayOfWeek actual = target.getThreeDaysAgo(LocalDate.now());
        System.out.println(actual);
    }

}
