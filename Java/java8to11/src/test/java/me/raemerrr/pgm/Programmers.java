/*
 * Programmers
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-12.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package me.raemerrr.pgm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class Programmers {

    @Test
    public void 완주하지_못한_선수_211012() throws Exception {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            m.put(participant[i], m.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            if (m.containsKey(completion[i])) {
                if (m.get(completion[i]) == 1) {
                    m.remove(completion[i]);
                } else {
                    m.put(completion[i], m.get(completion[i]) - 1);
                }
            }
        }

        System.out.println(m.entrySet().iterator().next().getKey());
    }

    @Test
    public void 전화번호_목록_211017() throws Exception {
        boolean answer = true;
        String[] phone_book = {"1195524421", "119", "97674223",};
        java.util.Map<Character, java.util.ArrayList<String>> m = new java.util.HashMap<>();
        for (String phoneNumber : phone_book) {
            if (m.containsKey(phoneNumber.charAt(0))) {
                m.get(phoneNumber.charAt(0)).add(phoneNumber);
            } else {
                m.put(phoneNumber.charAt(0), new java.util.ArrayList<>() {
                    {
                        add(phoneNumber);
                    }
                });
            }
        }
        for (java.util.Map.Entry<Character, java.util.ArrayList<String>> element : m.entrySet()) {
            java.util.ArrayList<String> v = element.getValue();
            v.sort((String a, String b) -> a.compareTo(b));
            for (int i = 0; i < v.size() - 1; i++) {
                if (v.get(i + 1).startsWith(v.get(i))) {
                    answer = false;
                    break;
                }
            }
            if (answer == false) {
                break;
            }
        }
        assertThat(answer).isFalse();
    }

    @Test
    public void 해시_위장() throws Exception {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1;
        java.util.Map<String, Integer> m = new java.util.HashMap<>();
        for (String[] arr : clothes) {
            m.put(arr[1], m.getOrDefault(arr[1], 0) + 1);
        }

        for (java.util.Map.Entry<String, Integer> element : m.entrySet()) {
            answer *= element.getValue() + 1;
        }
        // 아무것도 안 입는 경우는 없다.
        assertThat(answer - 1).isEqualTo(5);
    }
}
