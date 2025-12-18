package org.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution03Test {

    static Stream<Arguments> providePalindromes() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("abcabcbb", 3),
                Arguments.of("a", 1),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("providePalindromes")
    void testLongestPalindromeParameterized(String input, Integer expectedLen) {
        Solution03 sol = new Solution03();
        int res = sol.lengthOfLongestSubstring(input);
        assertEquals(expectedLen.intValue(), res, "长度应符合预期");
    }

}