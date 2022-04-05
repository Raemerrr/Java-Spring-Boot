package programmers;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class 쏘카_220319 {

    class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    void func(final List<Pair>[] nodes, final int index, final List<Integer> list, final int sum, final int k, final Set<Integer> answer) {
        if (sum == k) {
            Integer value = list.get(list.size() - 1);
            answer.add(value);
        } else if (sum < k) {
            for (Pair next : nodes[index]) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(next.index);
                func(nodes, next.index, temp, sum + next.value, k, answer);
            }
        }
    }

    @Test
    void test01() {
        int n = 6, k = 17;
        int[][] roads = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};
        //int n = 4, k = 10;
        //int[][] roads = {{0, 1, 2}, {0, 2, 3}};
        //int n = 4, k = 11;
        //int[][] roads = {{0, 1, 2}, {1, 2, 7}, {2, 3, 10}, {3, 0, 9}};
        Set<Integer> answer = new HashSet<>();
        List<Pair>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) nodes[i] = new ArrayList<>();
        for (int[] array : roads) {
            nodes[array[0]].add(new Pair(array[1], array[2]));
            nodes[array[1]].add(new Pair(array[0], array[2]));
        }
        func(nodes, 0, new ArrayList<>() {
            {
                add(0);
            }
        }, 0, k, answer);
        if (answer.isEmpty()) answer.add(-1);
        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(result)
                .forEach(System.out::println);
    }

    @Test
    void test02() {

    }
}
