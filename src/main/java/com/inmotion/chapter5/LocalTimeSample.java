package com.inmotion.chapter5;

import java.time.LocalTime;

/**
 * ローカル時刻
 */
public class LocalTimeSample {

    public LocalTime getRightNow(){
        return LocalTime.now();
    }

    public LocalTime getBedTime(){
        return LocalTime.of(22, 30, 0);
    }

    public LocalTime getWakeupTime(){
        return getBedTime().plusHours(8);
    }

}
