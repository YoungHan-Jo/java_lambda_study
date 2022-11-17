package study.lamda;

import java.util.Random;
import java.util.stream.IntStream;

public class Chap20 {
    public static void main(String[] args) {

        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(value -> System.out.println("value = " + value));

        IntStream randomIntStream = new Random().ints(6, 1, 46);
        randomIntStream.forEach(value -> System.out.println("randomIntStream = " + value));

    }
}
