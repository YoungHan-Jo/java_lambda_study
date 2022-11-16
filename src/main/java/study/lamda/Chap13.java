package study.lamda;

import java.util.function.Function;

public class Chap13 {
    public static void main(String[] args) {
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);

        Integer result = f.apply("10");
        System.out.println("result = " + result);

        Function<String, Integer> lamda = Integer::parseInt;
        Integer lamdaResult = lamda.apply("20");
        System.out.println("lamdaResult = " + lamdaResult);

    }
}
