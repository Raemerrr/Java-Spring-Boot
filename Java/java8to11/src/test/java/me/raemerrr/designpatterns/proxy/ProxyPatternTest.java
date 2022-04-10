package me.raemerrr.designpatterns.proxy;

import me.raemerrr.designpatterns.proxy._220407.ProxyClient;
import me.raemerrr.designpatterns.proxy._220407.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void test_220407() {
        ProxyClient proxyClient = new ProxyClient(new RealSubject());
        proxyClient.call();
        proxyClient.call();
        proxyClient.call();
    }

    @Test
    void test_220411() {
        ProxyClient proxyClient = new ProxyClient(new RealSubject());
        proxyClient.call();
        proxyClient.call();
        proxyClient.call();
    }
}
