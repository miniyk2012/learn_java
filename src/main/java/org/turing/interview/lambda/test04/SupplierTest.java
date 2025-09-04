package org.turing.interview.lambda.test04;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        String str1 = newString(new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        });
        System.out.println(str1);


        int[] arr = {5, 3, 45, 67, -9, 23, 555, 1};
        Integer max = getMax(() -> {
            int maxValue = arr[0];
            for (int i : arr) {
                if (i > maxValue) {
                    maxValue = i;
                }
            }
            return maxValue;
        });
        System.out.println("max=" + max);
    }

    private static String newString(Supplier<String> supplier) {
        return supplier.get();
    }

    private static Integer getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

}
