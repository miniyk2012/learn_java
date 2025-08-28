package org.turing.interview.lambda.test01;

@FunctionalInterface
public interface TestFunctionInterface {
    String test();

    default String getName() {
        return "default name";
    }

    static String getStaticName() {
        return "static name";
    }
}
