package study.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Chap53 {
    public static void main(String[] args) {

        Student3[] studentArr = {
                new Student3("김자바", "male", 1, 1, 100),
                new Student3("이자바", "female", 1, 1, 120),
                new Student3("박자바", "male", 1, 2, 200),
                new Student3("최자바", "female", 1, 2, 150),
                new Student3("조자바", "male", 1, 3, 160),
                new Student3("황자바", "female", 2, 1, 190),
                new Student3("전자바", "male", 2, 2, 130),
                new Student3("정자바", "female", 2, 2, 170),
                new Student3("채자바", "male", 2, 3, 110)
        };

        Stream<Student3> stuStream = Stream.of(studentArr);

        Map<Integer, List<Student3>> stuByBan = stuStream.collect(groupingBy(s -> s.getBan()));
        System.out.println("1반");
        List<Student3> ban1 = stuByBan.get(1);
        ban1.stream().forEach(s-> System.out.println(s));

        System.out.println("2반");
        List<Student3> ban2 = stuByBan.get(2);
        ban2.stream().forEach(s -> System.out.println(s));

        System.out.println();

        stuStream = Stream.of(studentArr);
        Map<Student3.Level, Long> stuCountByLevel = stuStream
                .collect(groupingBy(s -> {
                            if (s.getScore() >= 170) {
                                return Student3.Level.HIGH;
                            } else if (s.getScore() >= 140) {
                                return Student3.Level.MID;
                            } else {
                                return Student3.Level.LOW;
                            }
                        }, counting())
                );

        Long high = stuCountByLevel.get(Student3.Level.HIGH);
        System.out.println("high = " + high);

        Long mid = stuCountByLevel.get(Student3.Level.MID);
        System.out.println("mid = " + mid);

        Long low = stuCountByLevel.get(Student3.Level.LOW);
        System.out.println("low = " + low);

        System.out.println();


        System.out.println("학년,반 별로 나누기");
        stuStream = Stream.of(studentArr);

        Map<Integer, Map<Integer, List<Student3>>> stuByHakBan = stuStream.collect(
                groupingBy(s -> s.getHak(),
                        groupingBy(s -> s.getBan()))
        );

        System.out.println("1학년 1반");
        List<Student3> oneOne = stuByHakBan.get(1).get(1);
        oneOne.stream().forEach(s-> System.out.println(s));

        System.out.println("1학년 2반");
        List<Student3> oneTwo = stuByHakBan.get(1).get(2);
        oneTwo.stream().forEach(s-> System.out.println(s));

        System.out.println("2학년 1반");
        List<Student3> twoOne = stuByHakBan.get(2).get(1);
        twoOne.stream().forEach(s -> System.out.println(s));

        System.out.println("2학년 2반");
        List<Student3> twoTwo = stuByHakBan.get(2).get(2);
        twoTwo.stream().forEach(s -> System.out.println(s));


        System.out.println("학년,반의 1등");
        stuStream = Stream.of(studentArr);
        Map<Integer, Map<Integer, Student3>> topStuByHakBan = stuStream.collect(
                groupingBy(Student3::getHak,
                        groupingBy(Student3::getBan,
                                collectingAndThen(maxBy(Comparator.comparingInt(s -> s.getScore())), Optional::get)))
        );

        Student3 oneOneTop = topStuByHakBan.get(1).get(1);
        System.out.println("oneOneTop = " + oneOneTop);

        Student3 oneTwoTop = topStuByHakBan.get(1).get(2);
        System.out.println("oneTwoTop = " + oneTwoTop);


    }
}

class Student3 {
    String name;
    String gender;
    Integer hak;
    Integer ban;
    Integer score;

    public Student3(String name, String gender, Integer hak, Integer ban, Integer score) {
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
