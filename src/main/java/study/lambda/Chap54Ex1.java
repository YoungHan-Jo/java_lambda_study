package study.lambda;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Chap54Ex1 {
    public static void main(String[] args) {

        Student4[] stuArr = {
                new Student4("윤자바","male",1,1,300),
                new Student4("문자바","female",1,1,250),
                new Student4("채자바","male",1,1,200),
                new Student4("지사나","female",1,2,150),
                new Student4("전사나","female",1,2,50),
                new Student4("길사나","male",1,2,100),
                new Student4("한사나","male",1,3,150),
                new Student4("시사나","female",1,3,200),
                new Student4("가사나","male",2,1,300),
                new Student4("감사나","female",2,1,250),
                new Student4("이사나","male",2,1,200),
                new Student4("조사나","female",2,2,150),
                new Student4("정사나","male",2,2,100),
                new Student4("최사나","female",2,2,50),
                new Student4("나사나","male",2,3,100),
                new Student4("김사나","female",2,3,150),
                new Student4("박사나","male",2,3,200),
        };

        System.out.println("1. 반 별로 그룹화");
        Map<Integer, List<Student4>> stuByBan = Stream.of(stuArr).collect(groupingBy(s -> s.getBan()));
        stuByBan.get(1).stream().forEach(s -> System.out.println(s));
        System.out.println();
        stuByBan.get(2).stream().forEach(s -> System.out.println(s));
        System.out.println();
        stuByBan.get(3).stream().forEach(s -> System.out.println(s));

        System.out.println();

        System.out.println("2. 성적별로 그룹화");

        Map<Student4.Level, List<Student4>> stuByLevel = Stream.of(stuArr).collect(groupingBy(s -> {
            if (s.getScore() >= 200) return Student4.Level.HIGH;
            else if (s.getScore() >= 100) return Student4.Level.MID;
            else return Student4.Level.LOW;
        }));

        TreeSet<Student4.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student4.Level key : keySet) {
            System.out.println(key);
            stuByLevel.get(key).stream().forEach(s -> System.out.println(s));
            System.out.println();
        }

        System.out.println("3.성적별 학생 수");

        Map<Student4.Level, Long> stuCntByLevel = Stream.of(stuArr).collect(groupingBy(s -> {
            if (s.getScore() >= 200) return Student4.Level.HIGH;
            else if (s.getScore() >= 100) return Student4.Level.MID;
            else return Student4.Level.LOW;
        }, counting()));

        for (Student4.Level key :
                stuCntByLevel.keySet()) {
            System.out.println(key + ":" + stuCntByLevel.get(key) + "명");

        }

        Map<Integer, Map<Integer, List<Student4>>> stuByHakBan = Stream.of(stuArr).collect(groupingBy(s -> s.getHak(),
                groupingBy(s -> s.getBan())));

        for (Map<Integer, List<Student4>> hak: stuByHakBan.values()){
            for (List<Student4> ban : hak.values()) {
                System.out.println();
                for (Student4 s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.println("5. 다중 그룹화 + 통계(학년별, 반별 1등)");

        Map<Integer, Map<Integer, Student4>> topStuByHakBan = Stream.of(stuArr).collect(
                groupingBy(s -> s.getHak(),
                        groupingBy(s -> s.getBan(),
                                collectingAndThen(
                                        maxBy(Comparator.comparingInt(s -> s.getScore())),
                                        Optional::get
                                )
                        )));

        Collection<Map<Integer, Student4>> hak = topStuByHakBan.values();

        for (Map<Integer, Student4> ban : hak) {
            for (Student4 s : ban.values()) {
                System.out.println(s);
            }
        }

        Map<String, Set<Student4.Level>> stuByScoreGroup = Stream.of(stuArr).collect(
                groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s -> {
                            if (s.getScore() >= 200) return Student4.Level.HIGH;
                            else if (s.getScore() >= 100) return Student4.Level.MID;
                            else return Student4.Level.LOW;
                        }, toSet()))
        );

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for (String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }


    }
}

class Student4 {

    String name;
    String gender;
    int hak;
    int ban;
    int score;

    public Student4(String name, String gender, int hak, int ban, int score) {
        this.name = name;
        this.gender = gender;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    enum Level {
        HIGH, MID, LOW
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
        return gender.equals("male");
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }
}
