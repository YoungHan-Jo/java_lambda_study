package study.lambda;

import java.util.function.Predicate;

public class Chap7 {

    public static void main(String[] args) {

        Predicate<String> isEmptyStr = s -> s.length() == 0;

        String str = "";

        if (isEmptyStr.test(str)) {
            System.out.println("This is an empty String.");

        }
    }
}
