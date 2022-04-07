package me.raemerrr.designpatterns.proxy.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyClient implements Subject{

    private static final String prefix = "@@@ ProxyClient Call >>";
    private static final String suffix = "@@@ ProxyClient End >>";
    private String result;

    private final RealSubject realSubjectl;

    public ProxyClient(RealSubject realSubject){
        this.realSubjectl = realSubject;
    }


    @Override
    public String call() {
        log.info("[{}]", prefix);
        long startTime = System.currentTimeMillis();
        if (result == null){
            result = realSubjectl.call();
        }
        long endTime = System.currentTimeMillis();
        log.info("[{}] : {}ms", suffix, endTime - startTime);
        return result;
    }
}
