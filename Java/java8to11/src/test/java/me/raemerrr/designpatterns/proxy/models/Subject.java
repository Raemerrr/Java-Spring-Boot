package me.raemerrr.designpatterns.proxy.models;

public interface Subject {
    String call();

    default void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
