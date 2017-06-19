package com.inmotion.chapter2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * {@link SimpleReduction}のテスト。
 */
public class SimpleReductionTest {

    SimpleReduction target = new SimpleReduction();

    String contents;

    @Before
    public void initialize(){
        StringBuilder sb = new StringBuilder();
        try (
                InputStream inputStream = ClassLoader.getSystemResourceAsStream("alice.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String content = null;
            while ((content = bufferedReader.readLine()) != null) {
                sb.append(content);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
        contents = sb.toString();
    }

    @Test
    public void testMax() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // expect
        String expect = "zigzag";

        // execute
        Optional<String> actual = target.max(words);

        // assert
        Assert.assertEquals(expect, actual.get());
    }

    @Test
    public void testFindFirst() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // expect
        String expect = "Quick";

        // execute
        Optional<String> actual = target.findFirst(words);

        // assert
        Assert.assertEquals(expect, actual.get());
    }

    @Test
    public void testFindAny() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // expect
        String expect = "Quick";

        // execute
        Optional<String> actual = target.findAny(words);

        // assert
        Assert.assertEquals(expect, actual.get());
    }

    @Test
    public void testAnyMatch() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        boolean actual = target.anyMatch(words);

        // assert
        Assert.assertTrue(actual);
    }
}
