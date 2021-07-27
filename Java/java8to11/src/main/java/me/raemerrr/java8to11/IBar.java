package me.raemerrr.java8to11;

public interface IBar /* extends IGreeting */{
    // IGreeting에서 제공하는 기본 메소드들을 사용하기 싫을때
    // 이렇게 된다면 Bar를 구현하는 클래스는 printNameUpperCase()를 정의해야한다.
    //void printNameUpperCase();

    default void printNameUpperCase() {
        System.out.println("Bar");
    }
}
