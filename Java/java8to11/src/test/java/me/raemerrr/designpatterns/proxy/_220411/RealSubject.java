package me.raemerrr.designpatterns.proxy._220411;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {

    private static final String prefix = "@@@ RealClass >>";

    @Override
    public String call() {
        log.info("[{}] {} Call()!!!", prefix, getClass().getName());
        sleep(1000);
        log.info("[{}] {} End()!!!", prefix, getClass().getName());
        return "ok";
    }
}
