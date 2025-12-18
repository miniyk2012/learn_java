package org.example;


import java.util.Arrays;

public class Main {


    private static int[] sort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[]{};
        }
        if (nums.length == 1) {
            return Arrays.copyOf(nums, nums.length);
        }
        int[] leftNums = new int[nums.length / 2];
        int[] rightNums = new int[nums.length - nums.length / 2];
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a < leftNums.length) {
                leftNums[a++] = nums[i];
            } else {
                rightNums[b++] = nums[i];
            }
        }
        leftNums = sort(leftNums);
        rightNums = sort(rightNums);
        return merge(leftNums, rightNums);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        if (i < left.length) {
            result[k++] = left[i++];
        }
        if (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }


    public static void bubbleSort(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums.length-1; j >= i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j-1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        String s = "abcd";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(s);

        int[] nums = new int[]{5, 9, 12, 2, 6};
        int[] sortedNums = sort(nums);
        System.out.println(Arrays.toString(sortedNums));


        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}