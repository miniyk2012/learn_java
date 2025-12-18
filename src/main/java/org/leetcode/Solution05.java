package org.leetcode;

public class Solution05 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = j-1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (j-i<2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
