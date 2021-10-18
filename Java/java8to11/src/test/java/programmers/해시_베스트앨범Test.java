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

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class 해시_베스트앨범Test {
    @Test
    public void 해시_베스트앨범() throws Exception {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        해시_베스트앨범 answer = new 해시_베스트앨범();
        int[] solution = answer.solution(genres, plays);
        assertThat(solution).contains(4, 1, 3, 0);
    }
}