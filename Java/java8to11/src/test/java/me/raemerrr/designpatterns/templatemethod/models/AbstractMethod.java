package me.raemerrr.designpatterns.templatemethod.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractMethod {

    private static final String prefix = "AbstractMethod execute() call!! >>";
    private static final String suffix = "AbstractMethod execute() end!! >>";

    public void execute(String message) {
        log.info("[{}] {}", prefix, message);
        long startTime = System.currentTimeMillis();
        call();
        long endTime = System.currentTimeMillis();
        log.info("[{}] {} time : {}", suffix, message, endTime - startTime);
    }

    protected abstract void call();
}
