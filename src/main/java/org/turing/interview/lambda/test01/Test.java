package org.turing.interview.lambda.test01;

public class Test {
    private static void test(TestFunctionInterface functionInterface) {
        functionInterface.test();
    }

    public static void main(String[] args) {
        test(new TestFunctionInterfaceImpl());

        // 匿名内部类
        test(new TestFunctionInterface() {
            @Override
            public void test() {
                System.out.println("Anonymous class test method");
            }
        });

        // Lambda 表达式
        test(() -> {
            System.out.println("Lambda test method1");
        });

        // 如果只有一行, 可以省略大括号
        test(() -> System.out.println("Lambda test method2"));
    }

}
