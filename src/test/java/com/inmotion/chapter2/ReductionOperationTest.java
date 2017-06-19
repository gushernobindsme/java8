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
 * {@link ReductionOperation}のテスト。
 */
public class ReductionOperationTest {

    ReductionOperation target = new ReductionOperation();

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
    public void testReduce() throws Exception {
        // parameter
        List<Integer> values = Arrays.asList(1,2,3,4,5);

        // execute
        Optional<Integer> actual = target.reduce(values);

        // assert
        Assert.assertEquals(Integer.valueOf(15), actual.get());
    }

    @Test
    public void testAccumulator() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        int actual = target.accumulator(words);

        // assert
        Assert.assertEquals(107717, actual);
    }

}
