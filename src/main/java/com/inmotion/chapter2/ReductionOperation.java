package com.inmotion.chapter2;

import java.util.List;
import java.util.Optional;

/**
 * リダクション操作の実装サンプル。
 */
public class ReductionOperation {

    public Optional<Integer> reduce(List<Integer> values){
        return values.stream()
                .reduce((x, y) -> x + y);
    }

    public int accumulator(List<String> words){
        return words.stream()
                .reduce(0,
                        (total, word) -> total + word.length(),
                        (total1, total2 )-> total1 + total2);
    }

}
