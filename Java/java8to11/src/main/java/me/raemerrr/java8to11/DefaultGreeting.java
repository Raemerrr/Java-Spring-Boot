package me.raemerrr.java8to11;

public class DefaultGreeting implements IGreeting, IBar {

    String name;

    public DefaultGreeting(String name) {
        this.name = name;
    }

    // implements하는 인터페이스의 Default 메소드가 겹친다면 직접 구현해야한다.
    @Override
    public void printNameUpperCase() {
        System.out.println("DefaultGreeting");
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
