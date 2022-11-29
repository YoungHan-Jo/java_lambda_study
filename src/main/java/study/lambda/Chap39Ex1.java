package study.lambda;

import java.util.Optional;
import java.util.OptionalInt;

public class Chap39Ex1 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        System.out.println("optStr = " + optStr.get());
        Optional<Integer> optInt = optStr.map(i -> i.length());
        System.out.println("optInt = " + optInt.get());

        Integer result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(i -> Integer.parseInt(i)).get();
        System.out.println("result1 = " + result1);
        Integer result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(i -> Integer.parseInt(i)).orElse(-1);
        System.out.println("result2 = " + result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x -> System.out.println("result3 = " + x));

        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();
        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());

        System.out.println(optInt1.getAsInt());
//        System.out.println(optInt2.getAsInt()); // NoSuchElementException
        System.out.println("optInt1 = " + optInt1);
        System.out.println("optInt2 = " + optInt2);

        System.out.println("optInt1.equals(optInt2) = " + optInt1.equals(optInt2));



    }
}
