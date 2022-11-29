package study.lambda;

import java.util.Random;
import java.util.stream.IntStream;

public class Chap19 {
    public static void main(String[] args) {

        IntStream intStream = new Random().ints();
        intStream.limit(5).forEach(value -> System.out.println(value));

        IntStream limitedStream = new Random().ints(3);
        limitedStream.forEach(value -> System.out.println("value = " + value));

    }
}
