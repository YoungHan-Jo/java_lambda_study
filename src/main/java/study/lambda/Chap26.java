package study.lambda;

import java.util.stream.IntStream;

public class Chap26 {

    public static void main(String[] args) {

        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3).limit(5).forEach(i -> System.out.print(i + " "));

        System.out.println();

        IntStream is1 = IntStream.of(1, 1, 2, 2, 3, 3, 4, 5, 5);
        is1.distinct().forEach(System.out::print);

        System.out.println();

        IntStream is2 = IntStream.rangeClosed(1, 10);
        is2.filter(i -> i % 2 == 0).forEach(System.out::print);


    }
}
