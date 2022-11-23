package study.lamda;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Chap41 {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("kim", 120));
        students.add(new Student("na", 80));
        students.add(new Student("park", 70));
        students.add(new Student("lee", 110));

        Stream<Student> stuStream = students.stream();

        boolean result = stuStream.anyMatch(s -> s.getTotalScore() <= 100);
        System.out.println("result = " + result);

        stuStream = students.stream().parallel();
        Optional<Student> optStudent1 = stuStream.filter(s -> s.getTotalScore() <= 100).findAny();
        if (optStudent1.isPresent()) {
            System.out.println(optStudent1.get());
        }

        stuStream = students.stream();
        Optional<Student> optStudent2 = stuStream.filter(s -> s.getTotalScore() <= 100).findFirst();
        if (optStudent2.isPresent()) {
            System.out.println(optStudent2.get());
        }

    }


    static class Student {
        private String name;
        private int totalScore;

        public Student(String name, int totalScore) {
            this.name = name;
            this.totalScore = totalScore;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", totalScore=" + totalScore +
                    '}';
        }

        public String getName() {
            return name;
        }

        public int getTotalScore() {
            return totalScore;
        }
    }
}
