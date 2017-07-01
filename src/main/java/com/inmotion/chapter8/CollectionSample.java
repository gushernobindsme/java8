package com.inmotion.chapter8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class CollectionSample {

    public void removeIf(List<String> words, String word){
        words.removeIf(w -> w.equals(word));
    }

    public void replaceAll(List<String> words){
        words.replaceAll(w -> w.concat("plus"));
    }

    public void comparator(Person[] people){
        Arrays.sort(people, Comparator.comparing(Person::getLastName));
    }

    public void comparator2(Person[] people){
        Arrays.sort(people, Comparator.comparing(Person::getLastName)
        .thenComparing(Person::getFirstName));
    }

    public void comparator3(Person[] people){
        Arrays.sort(people, Comparator.comparingInt(p -> p.getFirstName().length()));
    }

    public void comparator4(Person[] people){
        Arrays.sort(people, Comparator.comparing(Person::getMiddleName, Comparator.nullsFirst(Comparator.naturalOrder())));
    }

    class Person {
        private String firstName;
        private String middleName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

    }

}
