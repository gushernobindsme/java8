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
 * {@link StreamOperation}のテスト。
 */
public class StreamOperationTest {

    StreamOperation target = new StreamOperation();

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
    public void testBefore() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // expect
        long expect = 151;

        // execute
        long actual = target.before(words);

        // assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testAfter() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // expect
        long expect = 151;

        // execute
        long actual = target.after(words);

        // assert
        Assert.assertEquals(expect, actual);
    }

}
