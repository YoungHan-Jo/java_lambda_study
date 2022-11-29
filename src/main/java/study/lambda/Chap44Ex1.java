package study.lambda;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chap44Ex1 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr).forEach(System.out::println);

        System.out.println();

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        System.out.println("noEmptyStr = " + noEmptyStr);

        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's').findFirst();
        System.out.println("sWord = " + sWord.get());

        IntStream intStream1 = Stream.of(strArr).mapToInt(s -> s.length());
        IntStream intStream2 = Stream.of(strArr).mapToInt(s -> s.length());
        IntStream intStream3 = Stream.of(strArr).mapToInt(s -> s.length());
        IntStream intStream4 = Stream.of(strArr).mapToInt(s -> s.length());

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        System.out.println("count = " + count);

        int sum = intStream2.reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        OptionalInt max = intStream3.reduce((a, b) -> Integer.max(a, b));
        System.out.println("max = " + max.getAsInt());

        OptionalInt min = intStream4.reduce((a, b) -> Integer.min(a, b));
        System.out.println("min = " + min.getAsInt());


    }
}
