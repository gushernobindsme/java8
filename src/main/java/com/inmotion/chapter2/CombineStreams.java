package com.inmotion.chapter2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by eratakumi on 2017/06/18.
 */
public class CombineStreams {

    public List<Double> limit() {
        return Stream.generate(Math::random)
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<String> skip(String contents) {
        return Stream.of(contents.split("[\\P{L}]+"))
                .skip(25899)
                .collect(Collectors.toList());
    }

    public List<String> concat(Stream<String> stream1, Stream<String> stream2) {
        return Stream.concat(stream1, stream2)
            .collect(Collectors.toList());
    }

}
