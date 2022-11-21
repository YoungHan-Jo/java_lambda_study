package study.lamda;

import java.util.stream.Stream;

public class Chap33 {
    public static void main(String[] args) {
        Stream<String[]> strArrStream = Stream.of(
                new String[]{"abc", "def", "ghi"},
                new String[]{"ABC", "GHI", "JKLMN"}
        );

        Stream<Stream<String>> streamStream = strArrStream.map(i -> Stream.of(i));
        streamStream.forEach(i -> i.forEach(j -> System.out.print(j + " ")));

        System.out.println();
        strArrStream = Stream.of(
                new String[]{"abc", "def", "ghi"},
                new String[]{"ABC", "GHI", "JKLMN"}
        );

        Stream<String> stringStream = strArrStream.flatMap(i -> Stream.of(i));

        stringStream.forEach(i -> System.out.print(i + " "));

    }
}
