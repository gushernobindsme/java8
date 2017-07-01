package com.inmotion.chapter8;

import java.util.stream.Stream;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class NumericClass {

    public void reduce(int a, int b) {
        System.out.println("sum:" + Integer.sum(a, b));
        System.out.println("max:" + Integer.max(a, b));
        System.out.println("min:" + Integer.min(a, b));
    }

    public void reduceBoolean(boolean a, boolean b) {
        System.out.println("logicalAnd:" + Boolean.logicalAnd(a, b));
        System.out.println("logicalOr:" + Boolean.logicalOr(a, b));
        System.out.println("logicalXor:" + Boolean.logicalXor(a, b));
    }

    public void toUnsigned(byte a){
        System.out.println("toUnsignedInt:" + Byte.toUnsignedInt(a));
    }

    public void isFinite(double a){
        System.out.println("isFinite:" + Double.isFinite(a));
        System.out.println("isInfinite:" + Double.isInfinite(a));
    }

}
