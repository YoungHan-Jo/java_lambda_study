package study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chap16 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "ddd", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Stream<String> strStream1 = strList.stream();
        Stream<String> strStream2 = Arrays.stream(strArr);

        strStream2.sorted().forEach(System.out::println); // 스트림 사용
        strStream2 = Arrays.stream(strArr); // 스트림 사용 뒤 새로 생성해야함.

        List<String> sortedList = strStream2.sorted().collect(Collectors.toList());
        System.out.println("sortedList = " + sortedList);


        int sum = strStream1.parallel()
                .mapToInt(s -> s.length())
                .sum();
        System.out.println("sum = " + sum);


    }
}
