package study.lamda;

import java.io.File;
import java.util.Comparator;
import java.util.stream.Stream;

public class Chap30 {
    public static void main(String[] args) {
        Stream<File> fileStream = Stream.of(
                new File("Ex1.java"),
                new File("Ex2.exe"),
                new File("Ex3.zip"),
                new File("Ex3"),
                new File("Ex4.exe"));

        Stream<String> filenameStream = fileStream.map(i -> i.getName());
        filenameStream.sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i + " "));

        System.out.println();

        fileStream = Stream.of(
                new File("Ex1.java"),
                new File("Ex2.exe"),
                new File("Ex3.zip"),
                new File("Ex3"),
                new File("Ex4.exe"));

        fileStream.map(i -> i.getName())
                .filter(i -> i.indexOf(".") != -1)
                .map(i -> i.substring(i.indexOf(".")+1))
                .distinct()
                .forEach(i -> System.out.print(i + " "));
    }
}
