package org.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution283Test {
    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,0,3,12}, new int[] {1,3,12,0,0}),
                Arguments.of(new int[] {0}, new int[] {0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void testMoveZeroes(int[] input, int[] expected) {
        Solution283 sol = new Solution283();
        sol.moveZeroes(input);
        assertArrayEquals(expected, input, "数组应符合预期");
    }
}