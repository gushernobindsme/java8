package com.inmotion.chapter8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class WorkingWithFiles {

    public Optional<String> readLines(Path path) throws IOException{
        Stream<String> lines = Files.lines(path);
        return lines.filter(s -> s.contains("password"))
                .findFirst();
    }

    public Optional<String> readLinesAndClose(Path path) throws IOException{
        try(Stream<String> lines = Files.lines(path)) {
            return lines.filter(s -> s.contains("password"))
                    .findFirst();
        }
    }

    public Stream<Path> list(Path pathToDirectory) throws IOException{
        return Files.list(pathToDirectory);
    }

    public Stream<Path> walk(Path pathToRoot) throws IOException{
        return Files.walk(pathToRoot);
    }

    public String encode(String username, String password){
        String plainText = username + password;
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }

    public byte[] decode(String encodedString){
        return Base64.getDecoder().decode(encodedString.getBytes());
    }

}
