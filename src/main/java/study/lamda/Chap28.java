package study.lamda;

import java.util.stream.Stream;

public class Chap28 {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("dd", "aaa", "CC", "b");
        strStream.sorted().forEach(i-> System.out.print(i + " "));

    }
}
