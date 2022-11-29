package study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Chap17 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();

        intStream.forEach(System.out::println);
//        intStream.forEach(System.out::println); // 이미 닫혀서 사용불가



    }
}
