/*
 * 해시_베스트앨범
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-19.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

public class 해시_베스트앨범 {
    class Music implements Comparable<Music> {

        private int id;
        private String genre;
        private int play;

        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        public int getId() {
            return id;
        }

        public int getPlay() {
            return play;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public int compareTo(Music m) {
            if (this.getPlay() == m.getPlay()) return this.getId() - m.getId();
            return m.getPlay() - this.getPlay();
        }
    }

    public int sum(List<Music> list) {
        int result = 0;
        for (Music m : list) {
            result += m.getPlay();
        }
        return result;
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(i, genres[i], plays[i]))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(music -> music.getValue().stream().sorted().limit(2))
                .mapToInt(music -> music.getId()).toArray();
    }
}
