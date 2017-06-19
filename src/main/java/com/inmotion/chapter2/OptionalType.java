package com.inmotion.chapter2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Optional型の実装サンプル。
 */
public class OptionalType {

    public void ifPresent(List<String> words, String searchWord){
        words.stream()
                .filter(s -> s.startsWith(searchWord))
                .findFirst()
                .ifPresent(w -> System.out.println(w));
    }

    public Optional<String> map(List<String> words, String searchWord){
        return words.stream()
                .filter(s -> s.startsWith(searchWord))
                .findFirst()
                .map(String::toUpperCase);
    }

    public String orElse(Optional<String> optionalString){
        return optionalString.orElse("");
    }

    public String orElseGet(Optional<String> optionalString){
        return optionalString.orElseGet(() -> System.getProperty("user.dir"));
    }

    public String orElseThrow(Optional<String> optionalString){
        return optionalString.orElseThrow(NoSuchElementException::new);
    }

    public Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.of(1 /x);
    }

    public Optional<Double> squareRoot(Double x){
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
