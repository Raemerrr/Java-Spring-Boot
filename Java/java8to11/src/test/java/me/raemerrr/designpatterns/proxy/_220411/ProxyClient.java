package me.raemerrr.designpatterns.proxy._220411;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyClient implements Subject {

    private static final String prefix = "@@@ ProxyClient >>";
    private final RealSubject realSubject;
    private String result;

    public ProxyClient(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public String call() {
        log.info("[{}] {} Call!!", prefix, getClass().getName());
        if (result.isEmpty()) {
            result = realSubject.call();
        }
        log.info("[{}] {} End!!", prefix, getClass().getName());
        return result;
    }
}
