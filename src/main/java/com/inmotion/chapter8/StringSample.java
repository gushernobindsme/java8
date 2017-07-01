package com.inmotion.chapter8;

import java.time.ZoneId;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class StringSample {

    public String join(){
        return String.join(", ", ZoneId.getAvailableZoneIds());
    }

}
