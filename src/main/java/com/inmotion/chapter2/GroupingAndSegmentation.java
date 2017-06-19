package com.inmotion.chapter2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * グループ分けと分割の実装サンプル。
 */
public class GroupingAndSegmentation {

    public Map<String, List<Locale>> coutryToLocales() {
        return Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry));
    }

    public Map<Boolean, List<Locale>> englishAndOtherLocales() {
        return Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.partitioningBy(
                        l -> l.getLanguage().equals("en")));
    }

    public Map<String, Set<Locale>> coutryToLocalesToSet() {
        return Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
    }

    public Map<String, Long> coutryToLocalesCounts() {
        return Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
    }

}
