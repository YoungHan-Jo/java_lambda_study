package study.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

public class Chap34Ex1 {
    public static void main(String[] args) {

        Stream<String[]> strArrStream = Stream.of(
                new String[]{"abc", "def", "ghi"},
                new String[]{"ABC", "GHI", "JKLMN"}
        );

//        Stream<Stream<String>> streamStream = strArrStream.map(Arrays::stream);
        Stream<String> strStream = strArrStream.flatMap(Arrays::stream);

        strStream.map(str -> str.toUpperCase())
                .distinct()
                .sorted()
                .forEach(s -> System.out.println(s));
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(l -> Stream.of(l.split(" +")))
                .map(s -> s.toLowerCase())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();


    }
}
