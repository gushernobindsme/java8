package com.inmotion.chapter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link MethodReference}のテスト。
 */
public class MethodReferenceTest {

    MethodReference target = new MethodReference();

    @Test
    public void testBefore() throws Exception {
        String[] expect = {"AbC","dEF","GHi"};
        String[] actual = target.before2(new String[]{"GHi","AbC","dEF"});
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testAfter() throws Exception {
        String[] expect = {"AbC","dEF","GHi"};
        String[] actual = target.after2(new String[]{"GHi","AbC","dEF"});
        Assert.assertArrayEquals(expect, actual);
    }

}
