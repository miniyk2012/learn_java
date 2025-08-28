package org.turing.interview.lambda.test03;

public class Test {
    private static void newThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.setDaemon(false);
        t.start();
    }

    public static void main(String[] args) {
        newThread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wakao");
        });

        newThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("wakao2");
            }
        });
    }


}
