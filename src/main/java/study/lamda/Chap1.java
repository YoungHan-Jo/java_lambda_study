package study.lamda;

import java.util.Arrays;

public class Chap1 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        Arrays.setAll(arr, i -> (int) (Math.random() * 5) + 1);

        Arrays.stream(arr).forEach(i -> System.out.println("i = " + i));
    }
}
