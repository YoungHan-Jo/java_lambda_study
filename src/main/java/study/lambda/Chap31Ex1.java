package study.lambda;

import java.io.File;
import java.util.stream.Stream;

public class Chap31Ex1 {
    public static void main(String[] args) {

        File[] fileArr = {new File("Ex1.java"),
                new File("Ex2.exe"),
                new File("Ex3.zip"),
                new File("Ex3"),
                new File("Ex4.exe")};

        Stream<File> fileStream = Stream.of(fileArr);

        Stream<String> filenameStream = fileStream.map(i -> i.getName());
        filenameStream.forEach(i -> System.out.print(i + " "));

        System.out.println();

        fileStream = Stream.of(fileArr);

        fileStream.map(i -> i.getName())
                .filter(s -> s.indexOf(".") > 0)
                .map(s -> s.substring(s.indexOf(".")+1))
                .map(i -> i.toUpperCase())
                .distinct()
                .forEach(i -> System.out.print(i + " "));


    }
}
