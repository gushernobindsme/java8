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
 * {@link OptionalType}のテスト。
 */
public class OptionalTypeTest {

    OptionalType target = new OptionalType();

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
    public void testIfPresentHasNotNull() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        target.ifPresent(words, "Q");
    }

    @Test
    public void testIfPresentHasNull() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        target.ifPresent(words, "QWERASDFZXCV");
    }

    @Test
    public void testMap() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // expect
        String expect = "QUICK";

        // execute
        Optional<String> actual = target.map(words, "Q");

        // assert
        Assert.assertEquals(expect, actual.get());
    }

    @Test
    public void testOrElse() throws Exception {
        // execute
        String actual = target.orElse(Optional.of("FUCK"));

        // assert
        Assert.assertEquals("FUCK", actual);
    }

    @Test
    public void testOrElseNull() throws Exception {
        // execute
        String actual = target.orElse(Optional.empty());

        // assert
        Assert.assertEquals("", actual);
    }

}
