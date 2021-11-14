/*
 * DataBox
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-11-14.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package me.raemerrr.java.multithread.databox;

import org.springframework.util.StringUtils;

public class DataBox {
    private String data;

    public synchronized String getData() {
        if (!StringUtils.hasText(this.data)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        String returnValue = this.data;
        System.out.println("Consumer Thread가 읽은 데이터 : " + returnValue);
        this.data = null;
        notify();
        return returnValue;
    }

    public synchronized void setData(String data) {
        if (StringUtils.hasText(this.data)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.data = data;
        System.out.println("Producer Thread가 읽은 데이터 : " + data);
        notify();
    }
}
