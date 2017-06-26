package com.inmotion.chapter5;

import java.time.*;

/**
 * ゾーン付き時刻
 */
public class ZonedDateTimeSample {

    public ZonedDateTime getApollo11launch(){
        return ZonedDateTime.of(
                1969,
                7,
                16,
                9,
                32,
                0,
                0,
                ZoneId.of("America/New_York"));
    }

    public ZonedDateTime skipped(){
        return ZonedDateTime.of(LocalDate.of(2013, 3, 31),
                LocalTime.of(2,30),
                ZoneId.of("Europe/Berlin"));
    }

    public ZonedDateTime ambiguous(){
        return ZonedDateTime.of(LocalDate.of(2013, 10, 27),
                LocalTime.of(2,30),
                ZoneId.of("Europe/Berlin"));
    }

    public ZonedDateTime nextMeeting(ZonedDateTime meeting){
        return meeting.plus(Period.ofDays(7));
    }

}
