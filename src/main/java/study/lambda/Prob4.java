package study.lambda;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prob4 {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 6).forEach(i ->
                IntStream.rangeClosed(1, 6).forEach(j ->
                        {
                            if (i + j == 6)
                                System.out.println("[" + i + "," + j + "]");
                        }
                )
        );


        System.out.println("=================================");

        String[] strArr = {"aaa", "bb", "c", "dddd"};

        Stream<String> strStream = Stream.of(strArr);

        int sum = strStream.mapToInt(str -> str.length()).sum();
        System.out.println("sum = " + sum);

        strStream = Stream.of(strArr);

        Integer result = strStream.collect(Collectors.summingInt(s -> s.length()));
        System.out.println("result = " + result);

        strStream = Stream.of(strArr);
        IntStream intStream = strStream.mapToInt(str -> str.length());
        Optional<Integer> max = intStream.boxed().collect(Collectors.reducing((a, b) -> Integer.max(a, b)));
        System.out.println("max = " + max.get());

        System.out.println("============================");

        IntStream intStream1 = new Random().ints(6, 1, 46);
        intStream1.forEach(i ->
                System.out.println(i)
        );

    }
}
