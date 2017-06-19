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

/**
 * {@link CollectResults}のテスト。
 */
public class CollectResultsTest {

    CollectResults target = new CollectResults();

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
    public void testJoining() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        String actural = target.joining(words);

        // assert
        Assert.assertNotNull(actural);
    }

    @Test
    public void testJoiningWithDelimiter() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        String actural = target.joiningWithDelimiter(words);

        // assert
        Assert.assertNotNull(actural);
    }

    @Test
    public void testGetAverage() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        double actural = target.getAverage(words);

        // assert
        Assert.assertEquals("4.158796957646423", String.valueOf(actural));
    }

    @Test
    public void testGetMax() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        double actural = target.getMax(words);

        // assert
        Assert.assertEquals("21.0", String.valueOf(actural));
    }


}
