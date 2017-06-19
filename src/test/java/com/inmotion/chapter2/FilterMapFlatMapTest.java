package com.inmotion.chapter2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@link FilterMapFlatMap}のテスト。
 */
public class FilterMapFlatMapTest {

    FilterMapFlatMap target = new FilterMapFlatMap();

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
    public void testFilter() throws Exception {
        // parameter
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // execute
        List<String> actual = target.filter(words);

        // check
        actual.stream()
                .forEach(w -> Assert.assertTrue(w.length() > 12));
    }

    @Test
    public void testMap() throws Exception {
        // parameter
        List<String> words = Arrays.asList("FUCK", "YOU");

        // execute
        List<String> actual = target.map(words);

        // check
        Assert.assertEquals(actual.toString(),"[fuck, you]");
    }

    @Test
    public void testFlatMap() throws Exception {
        // parameter
        List<List<String>> nestedList = new ArrayList<>();
        List<String> list1 = Arrays.asList("A", "B", "C", "D", "E");
        List<String> list2 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> list3 = Arrays.asList("あ", "い", "う", "え", "お");
        nestedList.add(list1);
        nestedList.add(list2);
        nestedList.add(list3);

        // execute
        List<String> actual = target.flatMap(nestedList);

        // check
        Assert.assertEquals(actual.toString(),"[A, B, C, D, E, a, b, c, d, e, あ, い, う, え, お]");
    }

}
