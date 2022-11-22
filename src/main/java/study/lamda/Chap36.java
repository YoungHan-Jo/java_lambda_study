package study.lamda;

import java.util.Optional;

public class Chap36 {
    public static void main(String[] args) {

        String str = "abc";

        Optional<String> optVal = Optional.of(str);
        Optional<String> optNull = Optional.ofNullable(null);

        Optional<String> optInit = Optional.empty();

    }
}
