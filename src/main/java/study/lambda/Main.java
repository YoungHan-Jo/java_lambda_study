package study.lambda;

public class Main {

    public static void main(String[] args) {

        Calculator cal = new CalculatorSharp();

        int a = 2, b = 4;

        int add = cal.add(a, b);
        System.out.println("add = " + add);

        int mul = cal.mul(a, b);
        System.out.println("mul = " + mul);
    }

}
