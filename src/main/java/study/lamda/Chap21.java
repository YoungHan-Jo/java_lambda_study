package study.lamda;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chap21 {
    public static void main(String[] args) {

        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
        evenStream.limit(10).forEach(integer -> System.out.print(integer + ", "));

        System.out.println();

        Stream<Integer> randomStream = Stream.generate(() -> (int)(Math.random()*10) + 1);
        randomStream.limit(10).forEach(i -> System.out.print(i + ", "));

        System.out.println();

        IntStream intStream = Stream.iterate(0, n -> n + 2).mapToInt(i -> Integer.valueOf(i));
        intStream.limit(5).forEach(i -> System.out.print(i + ", "));

        System.out.println();

        intStream = Stream.iterate(0, n -> n + 2).mapToInt(i -> Integer.valueOf(i));
        Stream<Integer> boxed = intStream.boxed();
        boxed.limit(5).forEach(i -> System.out.print(i + ", "));
    }
}
