package study.lambda;

import java.util.stream.IntStream;

public class Prob1 {
    public static void main(String[] args) {

        PrintVar f = (String name, int i) -> System.out.println(name + "=" + i);
        f.one("김", 1);

        Square s = x -> x * x;
        int result = s.run(3);
        System.out.println("s * s = " + result);

        Roll r = () -> (int) (Math.random() * 6);

        int randomNum = r.run();
        System.out.println("randomNum = " + randomNum);

        int[] intArr = {1, 2, 3, 4, 5};

        SumArr sa = (int[] arr) -> {
            int sum = 0;
            for (int i : arr)
                sum += i;
            return sum;
        };

        int sumResult = sa.run(intArr);
        System.out.println("sumResult = " + sumResult);

        EmptyArr ea = () -> new int[]{};

        int[] run = ea.run();
        System.out.println("run lenght = " + run.length);



    }

    interface EmptyArr {
        int[] run();
    }


    interface SumArr {
        int run(int[] arr);
    }

    interface PrintVar {
        void one(String name, int i);
    }

    interface Square {
        int run(int x);
    }

    interface Roll {
        int run();
    }



}
