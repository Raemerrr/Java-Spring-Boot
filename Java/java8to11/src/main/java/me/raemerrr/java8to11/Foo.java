package me.raemerrr.java8to11;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        // 1강 함수형 인터페이스와 람다 표현식 소개
        int baseNumber = 10;
        RunSomething runSomething = number -> number + baseNumber;
        System.out.println(runSomething.doit(20));


        // 2강 자바에서 제공하는 함수형 인터페이스
        Plus10 plus10_OG = new Plus10();
        System.out.println(plus10_OG.apply(1));

        Function<Integer, Integer> plus10 = (number) -> number + 10;
        Function<Integer, Integer> multiply2 = (number) -> number * 2;
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        Function<Integer, Integer> plus10AndMultiply2 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(20));
        System.out.println(plus10.andThen(multiply2).apply(20));

        // void 반환 형
        Consumer<Integer> printT = (number) -> System.out.println(number);
        printT.accept(10);

        // 매개변수 없이 제공하는 것
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // 인자 값을 받아서 Boolean 값으로 리턴
        Predicate<String> startsWithRaemerrr = (s) -> s.startsWith("Raemerrr");
        System.out.println(startsWithRaemerrr.test("2Raemerrr"));

        // 입력하는 값과 결과 값이 같은 경우
        // AS-IS
        //Function<Integer, Integer> plus10 = (number) -> number + 10;

        // TO-BE
        UnaryOperator<Integer> plus10Unary = (number) -> number + 10;
        System.out.println(plus10Unary.apply(20));
    }
}
