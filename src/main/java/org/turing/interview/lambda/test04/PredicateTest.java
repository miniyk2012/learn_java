package org.turing.interview.lambda.test04;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        String[] arr = {"hello", "world", "length", "java", "springboot", "springcloud"};
        for (String s : arr) {
            if (checkString(s, new Predicate<String>() {
                @Override
                public boolean test(String str) {
                    return s.length() > 5;
                }
            })) {
                System.out.println("length>5: " + s);
            } else {
                System.out.println("length<=5: " + s);
            }
        }

    }

    private static boolean checkString(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }

}
