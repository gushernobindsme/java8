package com.inmotion.chapter2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 状態を持つ変換メソッドの実装サンプル。
 */
public class StatefulConversion {

    public List<String> distinct(List<String> words){
        return words.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> sorted(List<String> words){
        return words.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
    }

}
