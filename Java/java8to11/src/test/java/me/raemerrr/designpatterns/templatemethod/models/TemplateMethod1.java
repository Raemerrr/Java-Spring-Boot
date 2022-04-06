package me.raemerrr.designpatterns.templatemethod.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethod1 extends AbstractMethod {
    @Override
    public void call() {
        sleep(1000);
        log.info("TemplateMethod1.call()!!!");
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
