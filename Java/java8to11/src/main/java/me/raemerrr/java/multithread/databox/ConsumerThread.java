/*
 * ConsumerThread
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-11-14.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package me.raemerrr.java.multithread.databox;

public class ConsumerThread extends Thread {
    private DataBox dataBox;

    public ConsumerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            String data = dataBox.getData();
        }
    }
}
