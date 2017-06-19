package com.inmotion.chapter2;

import java.util.List;

/**
 * ストリーム操作の実装サンプル。
 */
public class StreamOperation {

    public long before(final List<String> words) {
        long count = 0;
        for(String w : words){
            if (w.length() > 12){
                count++;
            }
        }
        return count;
    }

    public long after(final List<String> words) {
        return words.stream()
                .filter(w -> w.length() > 12)
                .count();
    }

}
