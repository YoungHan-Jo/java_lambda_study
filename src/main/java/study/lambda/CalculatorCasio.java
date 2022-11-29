package study.lambda;

public class CalculatorCasio implements Calculator{
    @Override
    public int add(int a, int b) {
        System.out.println("카시오 계산기로 계산한 결과입니다.");
        return a + b;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("카시오 계산기로 계산한 결과입니다.");
        return a * b;
    }


}
