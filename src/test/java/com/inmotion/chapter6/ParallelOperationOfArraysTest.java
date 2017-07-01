package com.inmotion.chapter6;

import com.inmotion.chapter2.CollectResults;
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
 * Created by eratakumi on 2017/07/01.
 */
public class ParallelOperationOfArraysTest {

    ParallelOperationOfArrays target = new ParallelOperationOfArrays();

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
    public void testParallelSort() throws Exception {
        // parameter
        String[] words = contents.split("[\\P{L}]+");

        // execute
        String[] actual = target.parallelSort(words);

        // assert
        for(String str : actual) {
            System.out.print(str + ", ");
        }
        Assert.assertNotNull(actual);
    }

    @Test
    public void testParallelSortHalf() throws Exception {
        // parameter
        String[] words = contents.split("[\\P{L}]+");

        // execute
        String[] actual = target.parallelSortHalf(words);

        // assert
        for(String str : actual) {
            System.out.print(str + ", ");
        }
        Assert.assertNotNull(actual);
    }

    @Test
    public void testParallelSetAll() throws Exception {
        // execute
        Integer[] actual = target.parallelSetAll();

        // assert
        for(Integer integer : actual) {
            System.out.print(integer + ", ");
        }
        Assert.assertNotNull(actual);
    }

}
