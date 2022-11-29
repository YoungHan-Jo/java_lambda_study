package study.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Chap47 {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1L,"kim", 120));
        students.add(new Student(2L, "na", 80));
        students.add(new Student(3L, "park", 70));
        students.add(new Student(4L, "lee", 110));

        Stream<Student> stuStream = students.stream();
        long count1 = stuStream.count();
        System.out.println("count1 = " + count1);

        stuStream = students.stream();
        Long count2 = stuStream.collect(counting());
        System.out.println("count2 = " + count2);

        stuStream = students.stream();
        int sum1 = stuStream.mapToInt(s -> s.totalScore).sum();
        System.out.println("sum1 = " + sum1);

        stuStream = students.stream();
        Integer sum2 = stuStream.collect(summingInt(s -> s.getTotalScore()));
        System.out.println("sum2 = " + sum2);

        stuStream = students.stream();
        Optional<Student> topStudent1 = stuStream.max(Comparator.comparingInt(s -> s.getTotalScore()));
        System.out.println("topStudent1 = " + topStudent1);

        stuStream = students.stream();
        Optional<Student> topStudent2 = stuStream.collect(maxBy(Comparator.comparingInt(s -> s.getTotalScore())));
        System.out.println("topStudent2 = " + topStudent2);

        stuStream = students.stream();
        IntSummaryStatistics stat1 = stuStream.mapToInt(s -> s.totalScore).summaryStatistics();
        System.out.println("stat1 = " + stat1);

        stuStream = students.stream();
        IntSummaryStatistics stat2 = stuStream.collect(summarizingInt(s -> s.totalScore));
        System.out.println("stat2 = " + stat2);
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
