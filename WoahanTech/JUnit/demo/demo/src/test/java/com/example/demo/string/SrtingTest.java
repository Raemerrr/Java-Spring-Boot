package com.example.demo.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SrtingTest {

    @Test
    void length2SplitTest() {
        String str = "1,2";
        String[] strArr = str.split(",");
        for (String d : strArr) {
            System.out.println(d);
        }
        assertThat(strArr).isNotNull().contains("1", "2");
    }

    @Test
    void length1SplitTest() {
        String str = "1";
        String[] strArr = str.split(",");
        for (String d : strArr) {
            System.out.println(d);
        }
        assertThat(strArr).isNotNull().contains("1");
    }

    @Test
    @DisplayName("()를 제거하고 출력 1")
    void substrTest() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).isNotNull().isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt() 사용 시 인덱스 범위를 넘어가는 것 테스트")
    void charAtTest2() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(3));
    }

}
