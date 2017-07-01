package com.inmotion.chapter8;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class OtherMinorChanges {

    private static String CAPTURE = "(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2})";

    public boolean checkNull(Stream<String> stream) {
        return stream.anyMatch(Objects::isNull);
    }

    public List<String> removeNull(Stream<String> stream) {
        return stream.filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public void delayedMessage(Logger logger, String x, String y) {
        logger.finest(() -> "x:" + x + ", y:" + y);
    }

    public void NamedCaptureGroup(String input) {
        Pattern pattern = Pattern.compile(CAPTURE);
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            String city = matcher.group("city");
        }
    }

    public List<Locale> languageRange() {
        List<Locale.LanguageRange> ranges = Stream.of("de", "*-CH")
                .map(Locale.LanguageRange::new)
                .collect(Collectors.toList());
        return Locale.filter(ranges, Arrays.asList(Locale.getAvailableLocales()));
    }

}
