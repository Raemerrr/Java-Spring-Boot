package me.raemerrr.designpatterns.strategy.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Americano implements Coffee {

    private static final String coffeeName = "Americano";

    @Override
    public void drop() {
        log.info("{} 커피 내리기", coffeeName);
        sleep(1000);
    }
}
