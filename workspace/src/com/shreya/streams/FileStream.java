package com.shreya.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStream {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("./src/com/shreya/streams/singers.txt")).map(String::toUpperCase).forEach(System.out::println);
        System.out.println();
        Files.lines(Paths.get("./src/com/shreya/streams/singers.txt")).filter(s -> s.contains("A")).forEach(System.out::println);

        Stream<String> data = Files.lines(Paths.get("./src/com/shreya/streams/data.txt"));
        data.map(s -> s.split(",")).filter(s -> s.length == 3).forEach(s -> System.out.println(s[0] + " : " + s[1]+" "+s[1]));
        data.close();

        Map<String,Integer> map = null;
        Stream<String> mapStream = Files.lines(Paths.get("./src/com/shreya/streams/data.txt"));
        map = mapStream.map(s -> s.split(",")).filter(s -> s.length>1).collect(Collectors.toMap(
                s -> s[0],
                s -> Integer.parseInt(s[1])
        ));
        mapStream.close();
        System.out.println(map);
    }
}
