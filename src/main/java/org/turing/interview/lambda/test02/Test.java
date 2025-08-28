package org.turing.interview.lambda.test02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    static void test() {
        Map<Apple, Integer> appleMap = new TreeMap<>(getComparator);
        appleMap.put(new Apple(1), 1);
        appleMap.put(new Apple(3), 3);
        appleMap.put(new Apple(2), 2);
        appleMap.put(new Apple(4), 4);
        // 打印 TreeMap 的键和值, 会安装key的顺序排列打印
        for (Map.Entry<Apple, Integer> entry : appleMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    static Comparator<Apple> getComparator = Comparator.comparing(Apple::getWeight).reversed();

    public static void main(String[] args) {
        test();
    }
}

