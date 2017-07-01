package com.inmotion.chapter6;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class ParallelOperationOfArrays {

    public String[] parallelSort(String[] words){
        Arrays.parallelSort(words);
        return words;
    }

    public String[] parallelSortHalf(String[] words){
        Arrays.parallelSort(words, words.length / 2, words.length);
        return words;
    }

    public Integer[] parallelSetAll(){
        Integer[] values = new Integer[30];
        Arrays.parallelSetAll(values, i -> i % 10);
        return values;
    }

}
