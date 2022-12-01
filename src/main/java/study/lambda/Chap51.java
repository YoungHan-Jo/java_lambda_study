package study.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Chap51 {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kim","male",90));
        studentList.add(new Student("na","male",50));
        studentList.add(new Student("park","female",55));
        studentList.add(new Student("lee","female",85));

        Stream<Student> stuStream = studentList.stream();

        Map<Boolean, List<Student>> stuByGender = stuStream.collect(partitioningBy(Student::isMale));

        List<Student> maleStudents = stuByGender.get(true);
        System.out.println("maleStudents = " + maleStudents);

        List<Student> femaleStudents = stuByGender.get(false);
        System.out.println("femaleStudents = " + femaleStudents);


        stuStream = studentList.stream();

        Map<Boolean, Long> countByGender = stuStream.collect(partitioningBy(s -> s.isMale(), counting()));

        Long maleCount = countByGender.get(true);
        System.out.println("maleCount = " + maleCount);
        Long femaleCount = countByGender.get(false);
        System.out.println("femaleCount = " + femaleCount);

        stuStream = studentList.stream();

        Map<Boolean, Optional<Student>> firstByGender = stuStream.collect(partitioningBy(s -> s.isMale(),
                maxBy(Comparator.comparingInt(s -> s.getScore()))));

        Optional<Student> maleFirst = firstByGender.get(true);
        System.out.println("maleFirst = " + maleFirst.get());
        Optional<Student> femaleFirst = firstByGender.get(false);
        System.out.println("femaleFirst = " + femaleFirst.get());

        stuStream = studentList.stream();

        Map<Boolean, Map<Boolean, List<Student>>> passedByGender = stuStream.collect(
                partitioningBy(s -> s.isMale(),
                        partitioningBy(s -> s.getScore() >= 60)
                )
        );

        List<Student> passedMale = passedByGender.get(true).get(true);
        System.out.println("passedMale = " + passedMale);
        List<Student> failedMale = passedByGender.get(true).get(false);
        System.out.println("failedMale = " + failedMale);
        List<Student> passedFemale = passedByGender.get(false).get(true);
        System.out.println("passedFemale = " + passedFemale);
        List<Student> failedFemale = passedByGender.get(false).get(false);
        System.out.println("failedFemale = " + failedFemale);


    }

    static class Student {
        String name;
        String gender;
        Integer score;

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", score=" + score +
                    '}';
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public Integer getScore() {
            return score;
        }

        public Student(String name, String gender, Integer score) {
            this.name = name;
            this.gender = gender;
            this.score = score;
        }

        public boolean isMale() {
            return gender.equals("male");
        }
    }
}
