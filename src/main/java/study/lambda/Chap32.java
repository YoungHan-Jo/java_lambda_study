package study.lambda;

import java.io.File;
import java.util.stream.Stream;

public class Chap32 {
    public static void main(String[] args) {

        File[] fileArr = {new File("Ex1.java"),
                new File("Ex2.exe"),
                new File("Ex3.zip"),
                new File("Ex3"),
                new File("Ex4.exe")};
        Stream<File> fileStream = Stream.of(fileArr);

        fileStream.map(f -> f.getName())
                .filter(i -> i.indexOf(".") > 0)
                .peek(i -> System.out.println("filename : " + i))
                .map(s -> s.substring(s.indexOf(".")+1))
                .peek(s -> System.out.println("extension : " +s))
                .forEach(s -> System.out.println(s));
    }
}
