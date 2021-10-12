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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
}
