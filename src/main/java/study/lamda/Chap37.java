package study.lamda;

import java.util.Optional;

public class Chap37 {
    public static void main(String[] args) {
        Optional<String> optVal = Optional.of("abc");
        String str1 = optVal.get();
        System.out.println("str1 = " + str1);
        String str2 = optVal.orElse("");
        System.out.println("str2 = " + str2);

        Optional<String> optVal2 = Optional.empty();
        String str3 = optVal2.orElseGet(String::new);
        System.out.println("str3 = " + str3);
//        String str4 = optVal2.orElseThrow(NullPointerException::new);

        if (optVal.isPresent()) {
            String str = optVal.get();
            System.out.println("str = " + str);
        }

        System.out.println();

        Optional.ofNullable("abc").ifPresent(i -> System.out.println(i));
    }
}
