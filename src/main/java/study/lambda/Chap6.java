package study.lambda;

public class Chap6 {

    public static void main(String[] args) {

        Chap6 ch = new Chap6();

        ch.aMethod(() -> System.out.println("MyMethod"));

    }

    @FunctionalInterface
    private interface MyFunction {
        void myMethod();
    }

    void aMethod(MyFunction f) {
        f.myMethod();
    }

}
