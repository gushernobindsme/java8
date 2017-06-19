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
import java.util.stream.Stream;

/**
 * {@link CombineStreams}のテスト。
 */
public class CombineStreamsTest {

    CombineStreams target = new CombineStreams();

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
    public void testLimit() throws Exception {
        // execute
        List<Double> actual = target.limit();
        actual.stream()
                .forEach(d -> System.out.println(d));
    }

    @Test
    public void testFilter() throws Exception {
        // execute
        List<String> actual = target.skip(contents);

        // check
        actual.stream()
                .forEach(w -> System.out.println(w));
    }

    @Test
    public void testConcat() throws Exception {
        // execute
        List<String> actual = target.concat(Stream.of("Fuck You"), Stream.of("Mother Fucker"));
        actual.stream()
                .forEach(d -> System.out.println(d));
    }

}
