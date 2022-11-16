package study.lamda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Chap14 {
    public static void main(String[] args) {
        Supplier<Member> s = () -> new Member();
        Supplier<Member> lamDaS = Member::new;

        Function<String, Member> f = str -> new Member(str);

        Member jo = f.apply("Jo");
        System.out.println("jo.getName() = " + jo.getName());

        Function<String, Member> lamDaF = Member::new;
        Member kim = lamDaF.apply("Kim");
        System.out.println("kim.getName = " + kim.getName());

        BiFunction<String, Integer, Member> biFunction = Member::new;

        Member member = biFunction.apply("jo", 30);
        System.out.println("member = " + member);

        Function<Integer, int[]> arrayInt = i -> new int[i];

        Function<Integer, int[]> lamDaArrayInt = int[]::new;

        int[] arr = lamDaArrayInt.apply(5);

        int length = arr.length;
        System.out.println("length = " + length);

    }



    private static class Member {
        private String name;
        private Integer age;

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Integer getAge() {
            return age;
        }

        public Member(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Member(String name) {
            this.name = name;
        }

        public Member() {
        }
    }

}
