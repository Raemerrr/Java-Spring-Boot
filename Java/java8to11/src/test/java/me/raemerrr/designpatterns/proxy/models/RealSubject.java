package me.raemerrr.designpatterns.proxy.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {

    private static final String prefix = "@@@ RealClass Call >>";
    private static final String suffix = "@@@ RealClass End >>";

    @Override
    public String call() {
        String result = "ok";
        log.info("[{}]", prefix);
        long startTime = System.currentTimeMillis();
        sleep(1000);
        long endTime = System.currentTimeMillis();
        log.info("[{}] : {}ms", suffix, endTime - startTime);
        return result;
    }
}
