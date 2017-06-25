package com.inmotion.chapter3;

import org.junit.Test;

/**
 * {@link ParametersOfLambda}のテスト。
 */
public class ParametersOfLambdaTest {

    ParametersOfLambda target = new ParametersOfLambda();

    @Test
    public void testRepeat() throws Exception {
        target.repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
    }

    @Test
    public void testRepeat2() throws Exception {
        target.repeat(10, i -> System.out.println("Hello, World!"));
    }

}
