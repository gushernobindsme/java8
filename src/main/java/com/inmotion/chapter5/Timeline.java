package com.inmotion.chapter5;

import java.time.Duration;
import java.time.Instant;

/**
 * タイムライン
 */
public class Timeline {

    public long duration() throws Exception {
        Instant start = Instant.now();
        runAlgorithm();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        return timeElapsed.toMillis();
    }

    private void runAlgorithm() throws InterruptedException {
        Thread.sleep(1000);
    }

}
