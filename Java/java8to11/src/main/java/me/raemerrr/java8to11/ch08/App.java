package me.raemerrr.java8to11.ch08;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        /**
         * 원본 데이터를 변경시키지 않는다.
         * 스트림은 오직 한 번만 처리한다.
         * 중계 오퍼레이터는 Stream을 Return한다.
         * 중계 오퍼레이터는 Lazy하다.
         * 중계 오퍼레이터들은 터미널(종료) 오퍼레이터가 오기 전까지 동작하지 않는다.
         * 종료 오퍼레이터는 Stream을 Return '안'한다.
         */
        {
            List<String> names = Stream.of("raemerrr", "Kang", "test", "XXX")
                    .collect(Collectors.toList());
            Stream<String> stringStream = names.stream().map(String::toUpperCase);
            stringStream.collect(Collectors.toList()).forEach(System.out::println);
            names.forEach(System.out::println);
        }
        System.out.println("==========================");

        /**
         * 병렬 처리
         */
        {
            List<String> names = Stream.of("raemerrr", "Kang", "test", "XXX")
                    .collect(Collectors.toList());
            names.parallelStream().map(s -> {
                System.out.println(s + " " + Thread.currentThread().getName());
                return s.toUpperCase();
            })
                    .collect(Collectors.toList()).forEach(System.out::println);

        }
        System.out.println("==========================");

    }
}
