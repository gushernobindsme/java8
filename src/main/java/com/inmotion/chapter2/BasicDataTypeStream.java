package com.inmotion.chapter2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 基本データ型ストリームの実装サンプル。
 */
public class BasicDataTypeStream {

    public IntStream of() {
        return IntStream.of(1, 2, 3, 4, 5);
    }

    public IntStream arraysStream(int[] values) {
        return Arrays.stream(values, 1, 3);
    }

    public IntStream zeroToNinetyNine() {
        return IntStream.range(0 ,100);
    }

    public IntStream zeroToHundred() {
        return IntStream.rangeClosed(0 ,100);
    }

    public List<Integer> mapToInt(List<String> wordList) {
        return wordList.stream()
                .mapToInt(String::length)
                .boxed()
                .collect(Collectors.toList());
    }

}
