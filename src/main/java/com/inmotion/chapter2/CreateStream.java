package com.inmotion.chapter2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * ストリームの作成、実装サンプル。
 */
public class CreateStream {

    public void streamOf(String contents){
        // 配列や複数個の文字列からストリームを生成する
        Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
        Stream<String> songs = Stream.of("gently", "down", "the", "stream");

        // 空ストリームの作成
        Stream<String> silence = Stream.empty();

        // 無限ストリームの作成
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
    }

}
