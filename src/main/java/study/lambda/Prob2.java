package study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Flow;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Prob2 {
    public static void main(String[] args) {

        Function<String, Integer> stringIntegerFunction = String::length;

        Integer length = stringIntegerFunction.apply("abcde");
        System.out.println("length = " + length);

        Function<int[], IntStream> intStreamFunction = Arrays::stream;

        BiFunction<String, String, Boolean> stringStringBooleanBiFunction = String::equals;

        IntBinaryOperator intBinaryOperator = Integer::compare;

        BiFunction<String, Integer, Card> aNew = Card::new;

        Consumer<String> stringConsumer = System.out::println;

        stringConsumer.accept("sout");

        Runnable random = () -> Math.random();

        Function<String, String> stringStringFunction = String::toUpperCase;

        Runnable runnable = () -> new NullPointerException();

        Function<Optional, Object> optionalObjectFunction = Optional::get;

        BiFunction<StringBuffer, String, StringBuffer> stringBufferStringStringBufferBiFunction = StringBuffer::append;

        IntBinaryOperator intBinaryOperator1 = (int a, int b) -> a > b ? a : b;


    }
}

class Card {
    String kind;
    int num;

    public Card(String kind, int num) {
        this.kind = kind;
        this.num = num;
    }
}

