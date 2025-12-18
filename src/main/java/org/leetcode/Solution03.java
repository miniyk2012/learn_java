package org.leetcode;


public class Solution03 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxLength = 1;
        int left = 0;
        int right = 0;
        int maxLeft = left, maxRight = right;
        while (right < s.length() && left < s.length()) {
            int index = s.indexOf(s.charAt(right), left);
            if (index >= left && index < right) {
                if (right - left > maxLength) {
                    maxLength = right - left;
                    maxLeft= left;
                    maxRight= right;
                }
                left = index + 1;
            }
            right++;
        }
        if (right - left > maxLength) {
            maxLength = right - left;
            maxLeft= left;
            maxRight= right;
        }
//        System.out.printf("%d %d\n", maxLeft, maxRight);
        return maxLength;
    }

}
