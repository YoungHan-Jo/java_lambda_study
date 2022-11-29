package study.lambda;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Chap48 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(1, 26).distinct().limit(6);
        OptionalInt max1 = intStream.reduce((a, b) -> Integer.max(a, b));
        System.out.println("max1 = " + max1.getAsInt());
        intStream = new Random().ints(1, 26).distinct().limit(6);
        Optional<Integer> max2 = intStream.boxed().collect(reducing(Integer::max));
        System.out.println("max2 = " + max2.get());

        intStream = new Random().ints(1, 26).distinct().limit(6);
        int sum1 = intStream.reduce(0, (a, b) -> a + b);
        System.out.println("sum1 = " + sum1);
        intStream = new Random().ints(1, 26).distinct().limit(6);
        Integer sum2 = intStream.boxed().collect(reducing(0, (a, b) -> a + b));
        System.out.println("sum2 = " + sum2);




        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1L,"kim", 120));
        students.add(new Student(2L, "na", 80));
        students.add(new Student(3L, "park", 70));
        students.add(new Student(4L, "lee", 110));

        Stream<Student> stuStream = students.stream();
        int grandTotal1 = stuStream.mapToInt(s -> s.getTotalScore()).sum();
        System.out.println("grandTotal1 = " + grandTotal1);

        stuStream = students.stream();
        Integer grandTotal2 = stuStream.collect(reducing(0, s -> s.getTotalScore(), (a, b) -> a + b));
        System.out.println("grandTotal2 = " + grandTotal2);

    }

    static class Student {

        private Long id;
        private String name;
        private int totalScore;

        public Student(Long id, String name, int totalScore) {
            this.id = id;
            this.name = name;
            this.totalScore = totalScore;
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", totalScore=" + totalScore +
                    '}';
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getTotalScore() {
            return totalScore;
        }
    }
}
