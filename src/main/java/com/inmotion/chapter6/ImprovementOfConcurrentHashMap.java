package com.inmotion.chapter6;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class ImprovementOfConcurrentHashMap {

    public void before(ConcurrentHashMap<String, Long> map, String word) {
        Long oldValue;
        Long newValue;
        do {
            oldValue = map.get(word);
            newValue = oldValue == null ? 1 : oldValue + 1;
        } while (!map.replace(word, oldValue, newValue));
    }

    public void after(ConcurrentHashMap<String, LongAdder> map, String word) {
        map.putIfAbsent(word, new LongAdder()).increment();
    }

    public void compute(ConcurrentHashMap<String, Long> map, String word) {
        map.compute(word, (k, v) -> v == null ? 1 : v + 1);
    }

    public void computeIfAbsent(ConcurrentHashMap<String, LongAdder> map, String word) {
        map.computeIfAbsent(word, k -> new LongAdder()).increment();
    }

    public void merge(ConcurrentHashMap<String, Long> map, String word) {
        map.merge(word, 1L, Long::sum);
    }

    public void forEach(ConcurrentHashMap<String, Long> map, long threshold) {
        map.forEach(threshold,
                (k, v) -> System.out.println(k + "->" + v));
    }

    public void forEach2(ConcurrentHashMap<String, Long> map, long threshold) {
        map.forEach(threshold,
                (k, v) -> k + "->" + v,
                System.out::println);
    }

    public void reduceValues(ConcurrentHashMap<String, Long> map, long threshold) {
        map.reduceValues(threshold, Long::sum);
    }

    public void reduceValues2(ConcurrentHashMap<String, Long> map, long threshold) {
        map.reduceKeys(threshold, String::length, Integer::max);
    }

    public void reduceValuesToLong(ConcurrentHashMap<String, Long> map, long threshold) {
        map.reduceValuesToLong(threshold, Long::longValue, 0, Long::sum);
    }

}
