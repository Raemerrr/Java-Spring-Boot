package me.raemerrr.designpatterns.proxy;

import me.raemerrr.designpatterns.proxy.models.ProxyClient;
import me.raemerrr.designpatterns.proxy.models.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void test() {
        ProxyClient proxyClient = new ProxyClient(new RealSubject());
        proxyClient.call();
        proxyClient.call();
        proxyClient.call();
    }
}
