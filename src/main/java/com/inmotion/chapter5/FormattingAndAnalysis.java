package com.inmotion.chapter5;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * フォーマットと解析
 */
public class FormattingAndAnalysis {

    public String standardFormat(ZonedDateTime zonedDateTime){
        return DateTimeFormatter.ISO_DATE_TIME.format(zonedDateTime);
    }

    public String localeSpecificFormat(ZonedDateTime zonedDateTime){
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                .format(zonedDateTime);
    }

    public String customFormat(ZonedDateTime zonedDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                .format(zonedDateTime);
    }

}
