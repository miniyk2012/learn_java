package org.turing.interview.lambda.test03;

import java.util.Date;

public class Test {
    private static void newThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.setDaemon(false);
        t.start();
    }

    public static void main(String[] args) {
        Date date = new Date();
        newThread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(date);
            System.out.println(Thread.currentThread().getName());
        });

        newThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
    }


}
