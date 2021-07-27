package me.raemerrr.java8to11;

public interface IGreeting {
    void printName();

    // 이전에는 인터페이스에 기능을 추가하면
    // 상속받은 클래스들에 구현체가 없어 오류 발생.
    //void printNameUpperCase();

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static void printAnything() {
        System.out.println("Greeting");
    }

    String getName();
}
