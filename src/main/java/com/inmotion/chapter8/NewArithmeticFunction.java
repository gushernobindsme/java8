package com.inmotion.chapter8;

import java.time.LocalTime;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class NewArithmeticFunction {

    public long multipleExact(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public int floorMod(LocalTime time) {
        int position = time.getHour();
        int adjustment = time.getMinute() / 60;
        return Math.floorMod(position + adjustment, 12);
    }

    public double nextDown(Double a) {
        return Math.nextDown(a);
    }
}
