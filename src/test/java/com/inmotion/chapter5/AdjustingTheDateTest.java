package com.inmotion.chapter5;

import org.junit.Test;

import java.time.LocalDate;

/**
 * {@link AdjustingTheDate}のテスト。
 */
public class AdjustingTheDateTest {

    AdjustingTheDate target = new AdjustingTheDate();

    @Test
    public void testGetFirstTuesday() throws Exception {
        LocalDate actual = target.getFirstTuesday(LocalDate.now());
        System.out.println(actual);
    }

    @Test
    public void testGetNextWorkday() throws Exception {
        LocalDate actual = target.getNextWorkday(LocalDate.now());
        System.out.println(actual);
    }

}
