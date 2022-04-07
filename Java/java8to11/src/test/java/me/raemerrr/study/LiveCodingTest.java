package me.raemerrr.study;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LiveCodingTest {
//https://jeong-pro.tistory.com/212
//    이름, 취미, 소개
//    김프로, 축구:농구:야구, 구기종목 좋아요
//    정프로, 개발:당구:족구, 개발하는데 뛰긴 싫어
//    앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아
//    죠르디, 스포츠댄스:개발, 개발하는 죠르디

    List<List<String>> csv;

    @BeforeEach
    void setUp() {
        csv = new ArrayList<>() {
            {
                add(new ArrayList<>() {
                    {
                        add("이름");
                        add("취미");
                        add("소개");
                    }
                });
                add(new ArrayList<>() {
                    {
                        add("김프로");
                        add("축구:농구:야구");
                        add("구기종목 좋아요");
                    }
                });
                add(new ArrayList<>() {
                    {
                        add("정프로");
                        add("개발:당구:족구");
                        add("개발하는데 뛰긴 싫어");
                    }
                });
                add(new ArrayList<>() {
                    {
                        add("앙몬드");
                        add("피아노");
                        add("죠르디가 좋아요 좋아좋아너무좋아");
                    }
                });
                add(new ArrayList<>() {
                    {
                        add("죠르디");
                        add("스포츠댄스:개발");
                        add("개발하는 죠르디");
                    }
                });
            }
        };
    }

    @Test
    @DisplayName("취미별 인원 수를 구하라")
    void test_220407_01() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Test
    @DisplayName("취미별 정씨 성을 갖는 멤버 수를 구하라")
    void test_220407_02() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .filter(array -> array.get(0).startsWith("정"))
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Test
    @DisplayName("소개 내용에 '좋아'가 몇 번 등장하는지 구하라")
    void test_220407_03() {
        String pattern = "좋아";
        List<List<String>> lines = csv;
        lines.remove(0);
        int result = lines.stream()
                .filter(array -> array.get(2).contains(pattern))
                .map(array -> numberOfPattern_220407(array.get(2), pattern))
                .reduce(0, Integer::sum);
        log.info("result : {}", result);
    }

    int numberOfPattern_220407(String source, String pattern) {
        int idx = source.indexOf(pattern);
        if (idx == -1) return 0;
        return 1 + numberOfPattern_220407(source.substring(idx + 1), pattern);
    }

    @Test
    @DisplayName("Binary Search")
    void test_220407_04() {
        List<Integer> list = Arrays.asList(-20, -4, 1, 10, 45, 100);
        assertThat(binarySearch_220407(list, 0, list.size() - 1, 1000)).isFalse();
    }

    boolean binarySearch_220407(List<Integer> list, int left, int right, int target) {
        boolean result = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = list.get(mid);
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else /*if (midVal == target)*/ {
                result = true;
                break;
            }
        }
        return result;
    }

    @Test
    @DisplayName("String Shuffle")
    void test_220407_05() {
        String str = "apple";
        List<String> list = Arrays.stream(str.split("")).collect(Collectors.toList());
        Collections.shuffle(list);
        for (String s : list) System.out.print(s);
        System.out.println();
    }

    @Test
    @DisplayName("취미별 인원 수를 구하라")
    void test_220406_01() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    @DisplayName("취미별 정씨 성을 갖는 멤버 수를 구하라")
    void test_220406_02() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .filter(array -> array.get(0).startsWith("정"))
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    @DisplayName("소개 내용에 '좋아'가 몇 번 등장하는지 구하라")
    void test_220406_03() {
        String pattern = "좋아";
        List<List<String>> lines = csv;
        lines.remove(0);
        Integer result = lines.stream()
                .filter(array -> array.get(2).contains(pattern))
                .map(array -> numberOfPattern_220406(array.get(2), pattern))
                .reduce(0, Integer::sum);
        log.info("좋아 등장 횟수 : {}", result);
    }

    int numberOfPattern_220406(String source, String pattern) {
        int idx = source.indexOf(pattern);
        if (idx == -1) return 0;
        return 1 + numberOfPattern_220405(source.substring(idx + 1), pattern);
    }

    @Test
    @DisplayName("Binary Search")
    void test_220406_04() {
        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7, 10, 20, 500);
        assertThat(binarySearch_220406(list, 0, list.size() - 1, 3)).isTrue();
    }

    boolean binarySearch_220406(List<Integer> list, int left, int right, int target) {
        boolean result = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = list.get(mid);
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else /*if (midVal == target) */ {
                result = true;
                break;
            }
        }
        return result;
    }

    @Test
    @DisplayName("String Shuffle")
    void test_220406_05() {
        StringBuilder sb = new StringBuilder();
        String str = "addlsowke";
        List<String> list = Arrays.asList(str.split(""));
        Collections.shuffle(list);
        for (String s : list) sb.append(s);
        System.out.println(sb);
    }

    @Test
    @DisplayName("취미별 인원 수를 구하라")
    void test_220405_01() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .flatMap(list -> Arrays.stream(list.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }

    @Test
    @DisplayName("취미별 정씨 성을 갖는 멤버 수를 구하라")
    void test_220405_02() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .filter(list -> list.get(0).startsWith("정"))
                .flatMap(list -> Arrays.stream(list.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }

    @Test
    @DisplayName("소개 내용에 '좋아'가 몇 번 등장하는지 구하라")
    void test_220405_03() {
        String pattern = "좋아";
        List<List<String>> lines = csv;
        lines.remove(0);
        int result = lines.stream()
                .filter(array -> array.get(2).contains(pattern))
                .map(array -> numberOfPattern_220405(array.get(2), pattern))
                .reduce(0, Integer::sum);
        System.out.println(pattern + " : " + result);
    }

    int numberOfPattern_220405(String source, String pattern) {
        int index = source.indexOf(pattern);
        if (index == -1) {
            return 0;
        }
        return 1 + numberOfPattern_220405(source.substring(index + 1), pattern);
    }

    @Test
    @DisplayName("이분 탐색 구현")
    void test_220405_04() {
        List<Integer> list = Arrays.asList(1, 20, 50, 79, 300);
        boolean result = binary_search_220405(list, 0, list.size() - 1, 3000);
        Assertions.assertThat(result).isFalse();
    }

    boolean binary_search_220405(List<Integer> list, int left, int right, int target) {
        boolean result = false;
        while (left <= right) {
            int mid = right + left / 2;
            Integer midVal = list.get(mid);
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else /*if (midVal == target)*/ {
                result = true;
                break;
            }
        }
        return result;
    }

    @Test
    @DisplayName("취미별 인원 수를 구하라")
    void test_220327_01() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test
    @DisplayName("취미별 정씨 성을 갖는 멤버 수를 구하라")
    void test_220327_02() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .filter(array -> array.get(0).startsWith("정"))
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test
    @DisplayName("소개 내용에 '좋아'가 몇 번 등장하는지 구하라")
    void test_220327_03() {
        List<List<String>> lines = csv;
        lines.remove(0);
        Integer integer = lines.stream()
                .filter(array -> array.get(2).contains("좋아"))
                .map(array -> numberOfPattern(array.get(2), "좋아"))
                .reduce(Integer::sum).orElse(0);
        System.out.println("answer : " + integer);
    }

    @Test
    @DisplayName("취미별 인원 수를 구하라")
    void test01() {
        Map<String, Integer> m = new HashMap<>();
        List<List<String>> list = csv;
        list.remove(0);
        list.stream()
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .forEach(hobby -> m.put(hobby, m.getOrDefault(hobby, 0) + 1));
        m.entrySet().forEach(System.out::println);
    }

    @Test
    @DisplayName("취미별 정씨 성을 갖는 멤버 수를 구하라")
    void test02() {
        Map<String, Integer> m = new HashMap<>();
        List<List<String>> list = csv;
        list.remove(0);
        list.stream()
                .filter(array -> array.get(0).startsWith("정"))
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .forEach(hobby -> m.put(hobby, m.getOrDefault(hobby, 0) + 1));
        m.entrySet().forEach(System.out::println);
    }

    @Test
    @DisplayName("소개 내용에 '좋아'가 몇 번 등장하는지 구하라")
    void test03() {
        List<List<String>> lines = csv;
        lines.remove(0);
        final String pattern = "좋아";
        int result = lines.stream()
                .map(array -> numberOfPattern(array.get(2), pattern))
                .reduce(0, Integer::sum);
        System.out.println(result);
    }

    int numberOfPattern(String source, String pattern) {
        int idx = source.indexOf(pattern);
        if (idx == -1) {
            return 0;
        }
        return 1 + numberOfPattern(source.substring(idx + 1), pattern);
    }

    @Test
    @DisplayName("취미별 인원 수를 구하라2")
    void test04() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    @DisplayName("취미별 정씨 성을 갖는 멤버 수를 구하라")
    void test05() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .filter(array -> array.get(0).startsWith("정"))
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    @DisplayName("취미별 인원 수를 구하라3")
    void test06() {
        List<List<String>> lines = csv;
        lines.remove(0);
        lines.stream()
                .flatMap(array -> Arrays.stream(array.get(1).split(":")))
                .collect(Collectors.groupingBy(Function.identity()))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    @DisplayName("String Shuffle1")
    void test07() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        char[] array = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            array[i] = s.charAt(indices[i]);
        }
        Stream.of(array).forEach(System.out::println);
    }

    String shuffle(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> list = Arrays.asList(s.split(""));
        Collections.shuffle(list);
        for (String item : list) {
            sb.append(item);
        }
        return sb.toString();
    }

    @Test
    @DisplayName("String Shuffle")
    void test08() {
        String s = "codeleet";
        for (int i = 0; i < 3; i++) {
            System.out.println(shuffle(s));
        }
    }

    boolean binary_search_220325(List<Integer> list, int left, int right, int target) {
        boolean result = false;
        while (left <= right) {
            int mid = (right + left) / 2;
            int midVal = list.get(mid);
            if (midVal == target) {
                result = true;
                break;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    @Test
    @DisplayName("Binary Search")
    void test09() {
        //List<Integer> list = IntStream.rangeClosed(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> list = Arrays.asList(1, 4, 6, 7, 50, 600);
        assertThat(binary_search_220325(list, 0, list.size() - 1, 6000)).isFalse();
    }

    @Test
    @DisplayName("리스트에서 합이 N이 되는 두 수를 찾아라.")
    void test10() {
        //List<Integer> list = IntStream.rangeClosed(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> list = IntStream.of(1, 4, 6, 7, 50, 600).boxed().collect(Collectors.toList());


        assertThat(binary_search_220325(list, 0, list.size(), 5)).isFalse();
    }

    boolean binary_search_220326(int[] list, int left, int right, int target) {
        while (left < right) {
            int mid = (right + left) / 2;
            int midVal = list[mid];
            if (midVal == target) return true;
            else if (midVal < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    @Test
    @DisplayName("Binary Search")
    void test11() {
        int[] arr = IntStream.rangeClosed(1, 100).toArray();
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        assertThat(binary_search_220325(list, 0, list.size(), 1)).isTrue();
    }

}
