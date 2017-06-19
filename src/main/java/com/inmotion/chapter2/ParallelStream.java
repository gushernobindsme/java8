package com.inmotion.chapter2;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 並列ストリームの実装サンプル。
 */
public class ParallelStream {

    public List<String> parallel(List<String> words) {
        return words.stream()
                .parallel()
                .collect(Collectors.toList());
    }

    public AtomicInteger parallelCount(List<String> words) {
        AtomicInteger count = new AtomicInteger(0);
        words.stream()
                .parallel()
                .forEach(w -> {
                    if(w.length() < 12) {
                        count.incrementAndGet();
                    }
                });
        return count;
    }

    public List<String> unordered(List<String> words, int n) {
        return words.stream()
                .parallel()
                .unordered()
                .limit(n)
                .collect(Collectors.toList());
    }

    public Map<String, List<Locale>> groupingByConcurrent() {
        return Stream.of(Locale.getAvailableLocales())
                .parallel()
                .collect(Collectors.groupingByConcurrent(Locale::getCountry));
    }

}
