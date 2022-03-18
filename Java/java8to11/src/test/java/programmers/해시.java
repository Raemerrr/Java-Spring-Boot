/*
 * 해시_베스트앨범Test
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-19.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class 해시 {
    @Test
    @DisplayName("베스트앨범")
    public void 베스트앨범() throws Exception {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        해시_베스트앨범 answer = new 해시_베스트앨범();
        int[] solution = answer.solution(genres, plays);
        assertThat(solution).contains(4, 1, 3, 0);
    }

    @Test
    @DisplayName("완주하지 못한 선수")
    public void 완주하지_못한_선수_220318() throws Exception {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        Map<String, Integer> m = new HashMap<>();
        Arrays.stream(participant)
                .forEach(p -> {
                    m.put(p, m.getOrDefault(p, 0) + 1);
                });
        Arrays.stream(completion)
                .forEach(c -> {
                    m.put(c, m.get(c) - 1);
                });
        String answer = m.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .findFirst().get().getKey();
        assertThat(answer).isEqualTo("mislav");
    }
}