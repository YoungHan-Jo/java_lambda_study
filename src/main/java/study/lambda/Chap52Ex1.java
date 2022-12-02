package study.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Chap52Ex1 {
    public static void main(String[] args) {

        Student2[] studentArr = {
                new Student2("김자바", "male", 1, 1, 100),
                new Student2("이자바", "female", 1, 1, 120),
                new Student2("박자바", "male", 1, 2, 200),
                new Student2("최자바", "female", 1, 2, 150),
                new Student2("조자바", "male", 1, 3, 160),
                new Student2("황자바", "female", 2, 1, 190),
                new Student2("전자바", "male", 2, 2, 130),
                new Student2("정자바", "female", 2, 2, 170),
                new Student2("채자바", "male", 2, 3, 110)
        };

        System.out.println("1. 단순 성별로 분할");
        Stream<Student2> stuStream = Stream.of(studentArr);
        Map<Boolean, List<Student2>> listByGender = stuStream.collect(partitioningBy(s -> s.isMale()));
        System.out.println("--male--");
        List<Student2> male = listByGender.get(true);
        male.stream().forEach(System.out::println);
        System.out.println("--female--");
        List<Student2> female = listByGender.get(false);
        female.stream().forEach(System.out::println);

        System.out.println();

        System.out.println("2. 성별 학생 수");
        stuStream = Stream.of(studentArr);
        Map<Boolean, Long> countingByGender = stuStream.collect(partitioningBy(s -> s.isMale(), counting()));
        Long countMale = countingByGender.get(true);
        System.out.println("countMale = " + countMale);
        Long countFemale = countingByGender.get(false);
        System.out.println("countFemale = " + countFemale);

        System.out.println();

        System.out.println("3. 각 성별 최우수 학생");
        stuStream = Stream.of(studentArr);
        Map<Boolean, Optional<Student2>> bestStudentByGender = stuStream.collect(
                partitioningBy(Student2::isMale,
                        maxBy(Comparator.comparingInt(s -> (int) s.getScore()))
                )
        );

        Optional<Student2> bestMale = bestStudentByGender.get(true);
        System.out.println("bestMale = " + bestMale.get());
        Optional<Student2> bestFemale = bestStudentByGender.get(false);
        System.out.println("bestFemale = " + bestFemale.get());

        System.out.println("4. 각 성별 불합격 150미만 학생");
        stuStream = Stream.of(studentArr);
        Map<Boolean, Map<Boolean, List<Student2>>> failedStuByGender = stuStream.collect(partitioningBy(s -> s.isMale(),
                partitioningBy(s -> s.getScore() < 150)));
        System.out.println("failed Male");
        List<Student2> failedMale = failedStuByGender.get(true).get(true);
        failedMale.stream().forEach(s -> System.out.println(s));
        System.out.println("failed Female");
        List<Student2> failedFemale = failedStuByGender.get(false).get(true);
        failedFemale.stream().forEach(s -> System.out.println(s));


    }
}

class Student2 {
    String name;
    String gender;
    Integer hak;
    Integer ban;
    Integer score;

    public Student2(String name, String gender, Integer hak, Integer ban, Integer score) {
        this.name = name;
        this.gender = gender;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getHak() {
        return hak;
    }

    public Integer getBan() {
        return ban;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", hak=" + hak +
                ", ban=" + ban +
                ", score=" + score +
                '}';
    }

    public boolean isMale() {
        return this.gender.equals("male");
    }

    enum Level {
        HIGH,MID,LOW
    }

}
