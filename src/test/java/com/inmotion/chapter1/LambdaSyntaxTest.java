package com.inmotion.chapter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link LambdaSyntax}のテスト。
 */
public class LambdaSyntaxTest {

    LambdaSyntax target = new LambdaSyntax();

    @Test
    public void testBefore() throws Exception {
        String[] expect = {"6","45","123"};
        String[] actual = target.before(new String[]{"123","45","6"});
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testAfter() throws Exception {
        String[] expect = {"6","45","123"};
        String[] actual = target.after(new String[]{"123","45","6"});
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testBeforeNoneParameter() throws Exception {
        target.beforeNoneParameter();
    }

    @Test
    public void testAfterNoneParameter() throws Exception {
        target.afterNoneParameter();
    }
}
