package org.turing.interview.basic.example2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentIteratorTest {
    // 创建一个ArrayList对象
    private static List<String> list = new ArrayList<>();

    private static CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();

    public static void demo1() {
        // 给ArrayList添加三个元素："1"、"2"和"3"
        list.add("1");
        list.add("2");
        list.add("3");

        // 开启线程池，提交10个线程用于在list尾部添加5个元素"121"
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                for (int j = 0; j < 5; j++) {
                    list.add("121");
                }
            });
        }

        Iterator<String> iter = list.iterator();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                // 使用Iterator迭代器遍历list并输出元素值
                while (iter.hasNext()) {
                    System.err.println(iter.next());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }

    public static void demo2() {
        list2.add("1");
        list2.add("2");
        list2.add("3");

        // 开启线程池，提交10个线程用于在list尾部添加5个元素"121"
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                for (int j = 0; j < 5; j++) {
                    list2.add("121");
                }
            });
        }


        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                Iterator<String> iter = list2.iterator();
                // 使用Iterator迭代器遍历list并输出元素值
                while (iter.hasNext()) {
                    System.err.println(iter.next());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }

    public static void main(String[] args) {
        demo1();
//        demo2();

    }
}