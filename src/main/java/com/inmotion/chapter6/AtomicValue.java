package com.inmotion.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class AtomicValue {

    public long incrementAndGet(AtomicLong nextNumber){
        return nextNumber.incrementAndGet();
    }

    public void beforeObserveMaxValue(AtomicLong largest, long observed){
        long oldValue;
        long newValue;
        do {
            oldValue = largest.get();
            newValue = Math.max(oldValue, observed);
        } while (!largest.compareAndSet(oldValue, newValue));
    }

    public void afterObserveMaxValue(AtomicLong largest, long observed){
        largest.updateAndGet(x -> Math.max(x, observed));
    }

    public long add(long[] longArray){
        LongAdder adder = new LongAdder();
        LongAdder count = new LongAdder();

        for (long longValue : longArray) {
            adder.add(longValue);
            count.increment();
        }
        return adder.sum();
    }

    public long accumulate(long[] longArray){
        LongAccumulator accumulator = new LongAccumulator(Long::sum, 0);
        for (long longValue : longArray) {
            accumulator.accumulate(longValue);
        }
        return accumulator.get();
    }

}
