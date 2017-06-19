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
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link ParallelStream}のテスト。
 */
public class ParallelStreamTest {

    ParallelStream target = new ParallelStream();

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
    public void testParallel() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        List<String> actural = target.parallel(words);

        // assert
        Assert.assertNotNull(actural);
    }

    @Test
    public void testParallelCount() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        AtomicInteger actural = target.parallelCount(words);

        // assert
        Assert.assertEquals(25645, actural.get());
    }

    @Test
    public void testGroupingByConcurrent() throws Exception {
        // execute
        Map<String, List<Locale>> actural = target.groupingByConcurrent();

        // assert
        Assert.assertNotNull(actural);
    }

}
