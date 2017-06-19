package com.inmotion.chapter2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 結果を収集する処理の実装サンプル。
 */
public class CollectResults {

    public String[] toArray(List<String> words){
        return words.stream()
                .toArray(String[]::new);
    }

    public List<String> collectorsToList(List<String> words){
        return words.stream()
                .collect(Collectors.toList());
    }

    public Set<String> collectorsToSet(List<String> words){
        return words.stream()
                .collect(Collectors.toSet());
    }

    public TreeSet<String> collectorsToCollection(List<String> words){
        return words.stream()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public String joining(List<String> words){
        return words.stream()
                .collect(Collectors.joining());
    }

    public String joiningWithDelimiter(List<String> words){
        return words.stream()
                .collect(Collectors.joining(", "));
    }

    public double getAverage(List<String> words){
        return words.stream()
                .collect(Collectors.summarizingInt(String::length))
                .getAverage();
    }

    public double getMax(List<String> words){
        return words.stream()
                .collect(Collectors.summarizingInt(String::length))
                .getMax();
    }

}
