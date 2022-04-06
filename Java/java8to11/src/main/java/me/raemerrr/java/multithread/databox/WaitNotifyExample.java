/*
 * WaitNotifyExample
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-11-14.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package me.raemerrr.java.multithread.databox;

public class WaitNotifyExample {
    public void main(String[] args) {
        DataBox dataBox = new DataBox();

        ProducerThread producerThread = new ProducerThread(dataBox);
        ConsumerThread consumerThread = new ConsumerThread(dataBox);

        producerThread.start();
        consumerThread.start();
    }
}
