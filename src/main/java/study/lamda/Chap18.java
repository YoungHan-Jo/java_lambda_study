package study.lamda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chap18 {
    public static void main(String[] args) {
        Stream<String> strStream = Arrays.stream(new String[]{"a", "b", "c"}, 0, 2);
        strStream.forEach(System.out::println);

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(value -> System.out.println(value));

    }
}
