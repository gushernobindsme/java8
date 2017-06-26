package com.inmotion.chapter5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 日付の調整
 */
public class AdjustingTheDate {

    public LocalDate getFirstTuesday(LocalDate localDate){
        return LocalDate.of(localDate.getYear(), localDate.getMonth(), 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
    }

    TemporalAdjuster NEXT_WORKDAY = w -> {
        LocalDate result = (LocalDate) w;
        do {
            result = result.plusDays(1);
        } while (result.getDayOfWeek().getValue() >= 6);
        return result;
    };

    TemporalAdjuster SIMPLE_NEXT_WORKDAY = TemporalAdjusters.ofDateAdjuster(w -> {
        LocalDate result = (LocalDate) w;
        do {
            result = result.plusDays(1);
        } while (result.getDayOfWeek().getValue() >= 6);
        return result;
    });

    public LocalDate getNextWorkday(LocalDate localDate){
        return localDate.with(NEXT_WORKDAY);
    }

    public LocalDate getSimpleNextWorkday(LocalDate localDate){
        return localDate.with(SIMPLE_NEXT_WORKDAY); // 結果は同じ
    }
}
