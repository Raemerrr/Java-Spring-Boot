/*
 * MultiThread
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-11-13.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package me.raemerrr.java.multithread.beep;

import java.awt.*;

public class BeepPrintExample1 {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // nothing
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // nothing
            }
        }
    }
}
