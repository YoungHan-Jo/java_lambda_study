package study.lambda;

import java.util.Comparator;
import java.util.stream.Stream;

public class Chap29Ex1 {
    public static void main(String[] args) {

        Stream<Student> studentStream = Stream.of(
                new Student("가자바", 3, 12),
                new Student("나자바", 2, 12),
                new Student("다자바", 1, 13),
                new Student("라자바", 2, 13),
                new Student("마자바", 3, 14),
                new Student("바자바", 1, 14),
                new Student("사자바", 2, 15),
                new Student("아자바", 3, 16)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(i -> System.out.println(i));
    }
}

class Student implements Comparable<Student>{
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
