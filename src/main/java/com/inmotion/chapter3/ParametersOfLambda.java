package com.inmotion.chapter3;

import java.util.function.IntConsumer;

/**
 * ラムダ式のパラメータに関する実装サンプル。
 */
public class ParametersOfLambda {

    public void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

    public void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

}
