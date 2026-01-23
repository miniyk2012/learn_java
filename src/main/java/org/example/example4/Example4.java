package org.example.example4;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.Arrays;
import java.util.List;

public class Example4 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list.size());
        arr[0] = 3;
        System.out.println(list);  // [3, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}
