package me.raemerrr.designpatterns.proxy._220411;

public interface Subject {

    String call();

    default void sleep(Integer ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
