package me.raemerrr.designpatterns.strategy.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeeMachine {

    private static final String prefix = "@@@ CoffeeMachine Call >>";
    private static final String suffix = "@@@ CoffeeMachine End >>";

    public void execute(Coffee coffee) {
        log.info("[{}]", prefix);
        long startTime = System.currentTimeMillis();
        coffee.drop();
        long endTime = System.currentTimeMillis();
        log.info("[{}] : {}ms", suffix, endTime - startTime);

    }
}
