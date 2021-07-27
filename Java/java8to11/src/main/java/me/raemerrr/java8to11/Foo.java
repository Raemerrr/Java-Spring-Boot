package me.raemerrr.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        /* 1강 함수형 인터페이스와 람다 표현식 소개 */
        {
            int baseNumber = 10;
            RunSomething runSomething = number -> number + baseNumber;
            System.out.println(runSomething.doit(20));
        }
        /* 2강 자바에서 제공하는 함수형 인터페이스 */
        {
            Plus10 plus10_OG = new Plus10();
            System.out.println(plus10_OG.apply(1));

            Function<Integer, Integer> plus10 = (number) -> number + 10;
            Function<Integer, Integer> multiply2 = (number) -> number * 2;
            Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
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
        /* 3강 메소드 레퍼런스 */
        {
            // static 메소드의 메소드 래퍼런스
            UnaryOperator<String> hi = Greeting::hi;
            System.out.println(hi.apply("Raemerrr"));

            // static 메소드가 아닌 특정 객체의 인스턴스 메소드의 메소드 래퍼런스
            Greeting greeting = new Greeting();
            UnaryOperator<String> hello = greeting::hello;
            System.out.println(hello.apply("Raemerrr"));

            // 매개변수가 없는 생성자의 메소드 래퍼러스
            Supplier<Greeting> greetingSupplier = Greeting::new;
            // 생성과 함께 Name 출력
            System.out.println(greetingSupplier.get().getName());

            // 매개 변수가 있는 생성자의 메소드 래퍼러슨
            Function<String, Greeting> greetingFunction = Greeting::new;
            // 생성과 함께 Name 출력
            System.out.println(greetingFunction.apply("Raemerrr").getName());

            // 임의 객체의 인스턴스 메소드 참조
            String[] names = {"Raemerrr", "Kang", "XXX"};
            // AS-IS
//            Arrays.sort(names, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return 0;
//                }
//            });
            // TO-BE
            //Arrays.sort(names, (o1, o2) -> 0);
            Arrays.sort(names, String::compareToIgnoreCase);
            System.out.println(Arrays.toString(names));
        }
        /* 4강 인터페이스 기본 메소드와 스태틱 메소드 */
        {
            IGreeting greeting = new DefaultGreeting("Raemerrr");
            greeting.printName();
            greeting.printNameUpperCase();

            IGreeting.printAnything();
        }
    }
}
