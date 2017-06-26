package com.inmotion.chapter5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

/**
 * ローカルの日付
 */
public class LocalDateSample {

    public LocalDate getToday(){
        return LocalDate.now();
    }

    public LocalDate getAlonzosBirthday(){
        return LocalDate.of(1903, 6, 14);
    }

    public LocalDate getNextProgrammersDay(LocalDate localDate){
        return localDate.plusDays(255);
    }

    public Period until(LocalDate start, LocalDate end){
        return start.until(end);
    }

    public long untilDays(LocalDate start, LocalDate end){
        return start.until(end, ChronoUnit.DAYS);
    }

    public DayOfWeek getThreeDaysAgo(LocalDate start){
        return start.getDayOfWeek().plus(3);
    }

}
