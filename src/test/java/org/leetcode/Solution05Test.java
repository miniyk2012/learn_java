package org.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution05Test {
    @Test
    void testNullInput() {
        Solution05 sol = new Solution05();
        assertNull(sol.longestPalindrome(null));
    }

    @Test
    void testEmptyString() {
        Solution05 sol = new Solution05();
        assertEquals("", sol.longestPalindrome(""));
    }

    static Stream<Arguments> providePalindromes() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of("", 0, ""),
                Arguments.of("a", 1, "a"),
                Arguments.of("cbbd", 2, "bb"),
                Arguments.of("aaaa", 4, "aaaa"),
                Arguments.of("babad", 3, null) // "bab" 或 "aba" 都接受，因此 expectedExact 为 null，只校验长度和回文性
        );
    }

    @ParameterizedTest
    @MethodSource("providePalindromes")
    void testLongestPalindromeParameterized(String input, Integer expectedLen, String expectedExact) {
        Solution05 sol = new Solution05();
        String res = sol.longestPalindrome(input);

        if (input == null) {
            assertNull(res);
            return;
        }

        assertNotNull(res);
        assertEquals(expectedLen.intValue(), res.length(), "长度应符合预期");
        assertTrue(isPalindrome(res), "结果应为回文");

        if (expectedExact != null) {
            assertEquals(expectedExact, res, "当有精确期望时应相等");
        }
    }

    private static boolean isPalindrome(String s) {
        if (s == null) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}