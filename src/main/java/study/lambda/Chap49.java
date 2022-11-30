package study.lambda;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chap49 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1L,"kim", 120));
        students.add(new Student(2L, "na", 80));
        students.add(new Student(3L, "park", 70));
        students.add(new Student(4L, "lee", 110));

        Stream<Student> stuStream = students.stream();
        String stuNames1 = stuStream.map(s -> s.getName()).collect(Collectors.joining());
        System.out.println("stuNames1 = " + stuNames1);

        stuStream = students.stream();
        String stuNames2 = stuStream.map(s -> s.getName()).collect(Collectors.joining(", "));
        System.out.println("stuNames2 = " + stuNames2);

        stuStream = students.stream();
        String stuNames3 = stuStream.map(s -> s.getName()).collect(Collectors.joining(", ", "[", "]"));
        System.out.println("stuNames3 = " + stuNames3);
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
