package me.raemerrr.designpatterns.proxy._220407;

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
