package org.leetcode;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String minS = strs[0];
        for (int i =1; i<strs.length; i++) {
            if (minS.length() < strs[i].length()) {
                minS = strs[i];
            }
        }
        String res = "";
        for (int i=minS.length(); i>0; i--) {
            String sub = minS.substring(0, i);
            boolean isSub = true;
            for (String s : strs) {
                if (!s.startsWith(sub)) {
                    isSub = false;
                    break;
                }
            }
            if (isSub) {
                return sub;
            }
        }
        return res;
    }
}
