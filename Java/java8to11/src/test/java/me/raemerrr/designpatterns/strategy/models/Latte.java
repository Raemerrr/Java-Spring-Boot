package me.raemerrr.designpatterns.strategy.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Latte implements Coffee {

    private static final String coffeeName = "Latte";

    @Override
    public void drop() {
        log.info("{} 커피 내리기", coffeeName);
        sleep(2000);
    }
}
