package study.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Chap8Ex1 {

    public static void main(String[] args) {

        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i/10*10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);

        printEvenNum(c, p, list);

        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);


    }

    private static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }


    private static <T> void printEvenNum(Consumer<T> c, Predicate<T> p, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    private static void makeRandomList(Supplier<Integer> s, List<Integer> list) {
        IntStream.range(0,10).forEach(i -> list.add(s.get()));
    }
}
