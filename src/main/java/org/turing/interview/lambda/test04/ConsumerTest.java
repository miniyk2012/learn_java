package org.turing.interview.lambda.test04;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> c1 = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println("c1: " + s);
            }
        };
        Consumer<String> c2 = s -> System.out.println("c2: " + s);
        consumer("sheep", c1);
        doubleConsumer("sheep", c1, c2);

    }

    private static void consumer(String value, Consumer<String> consumer) {
        consumer.accept(value);
    }

    private static void doubleConsumer(String value, Consumer<String>... consumers) {
        Consumer<String> consumer = consumers[0];
        for (int i = 1; i < consumers.length; i++) {
            consumer = consumer.andThen(consumers[i]);
        }
        consumer.accept(value);
    }
}
