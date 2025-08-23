package org.turing.interview.basic.example3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(map.get(null)); // 输出 null
        System.out.println(map.containsKey(null)); // 输出 false
//        map.put(null, "a");
//        System.out.println(map.get(null)); // 输出 "a"
//        System.out.println(map.containsKey(null)); // 输出 true
        map.computeIfAbsent(null, new Function<String, Object>(){
            @Override
            public Object apply(String s) {
                System.out.println("wakao");
                return "b";
            }
        });
        System.out.println(map.get(null)); // 输出 "a"
        System.out.println(map.containsKey(null)); // 输出 true
    }
}
