package com.inmotion.chapter2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * マップへ収集する実装のサンプル。
 */
public class CollectToMap {

    public Map<Integer, String> toMap(List<Person> people){
        return people.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));
    }

    public Map<Integer, Person> toMapIdentity(List<Person> people){
        return people.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
    }

    public Map<String, Set<String>> getCountryLanguageSets(){
        return Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.toMap(l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return  r;
                        }));
    }

    public Map<Integer, Person> idToPerson(List<Person> people){
        return people.stream()
                .collect(Collectors.toMap(Person::getId,
                        Function.identity(),
                        (existingValue, newValue) -> { throw new IllegalStateException();},
                        TreeMap::new));
    }

    class Person {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }

}
