package org.example.example3;


import java.util.*;

public class Example3 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 1, 3, 4, 5, 3};
        int k = 6;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k) {
                    list.add(String.format("%d,%d", nums[i], nums[j]));
                }
            }
        }

        fastSum(nums, k);
    }

    public static List<String> fastSum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        List<String> ret = new LinkedList<>();
        for (int num : nums) {
            if (set.contains(k - num)) {
                ret.add(String.format("%d,%d", num, k - num));
            }
            set.add(num);
        }
        System.out.println(ret);
        return ret;
    }
}

