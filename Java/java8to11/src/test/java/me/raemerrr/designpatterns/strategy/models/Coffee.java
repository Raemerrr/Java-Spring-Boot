package me.raemerrr.designpatterns.strategy.models;

public interface Coffee {

    void drop();

    default void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
