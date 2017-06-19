package com.inmotion.chapter2;

import java.util.List;
import java.util.Optional;

/**
 * 単純なリダクションの実装サンプル。
 */
public class SimpleReduction {

    public Optional<String> max(List<String> words){
        return words.stream()
                .max(String::compareToIgnoreCase);
    }

    public Optional<String> findFirst(List<String> words){
        return words.stream()
                .filter(s -> s.startsWith("Q"))
                .findFirst();
    }

    public Optional<String> findAny(List<String> words){
        return words.stream()
                .filter(s -> s.startsWith("Q"))
                .findAny();
    }

    public boolean anyMatch(List<String> words){
        return words.stream()
                .anyMatch(s -> s.startsWith("Q"));
    }

}
