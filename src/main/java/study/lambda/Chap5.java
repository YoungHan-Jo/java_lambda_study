package study.lambda;

public class Chap5 {

    public static void main(String[] args) {

        MyFunction f = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int big = f.max(3, 5);

        System.out.println("big = " + big);

        MyFunction lamdaF = (a, b) -> a > b ? a : b;

        int lamdaBig = lamdaF.max(2, 9);

        System.out.println("lamdaBig = " + lamdaBig);

    }

    @FunctionalInterface
    private interface MyFunction {
        public abstract int max(int a, int b);
    }

}
