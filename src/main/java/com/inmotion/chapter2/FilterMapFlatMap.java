package com.inmotion.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * filter、map、flatMapの実装サンプル。
 */
public class FilterMapFlatMap {

    public List<String> filter(List<String> wordList) {
        return wordList.stream()
                .filter(w -> w.length() > 12)
                .collect(Collectors.toList());
    }

    public List<String> map(List<String> wordList) {
        return wordList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public List<String> flatMap(List<List<String>> nestedList){
        return nestedList.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
    }


}
