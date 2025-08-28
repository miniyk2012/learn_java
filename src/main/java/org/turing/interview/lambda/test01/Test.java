package org.turing.interview.lambda.test01;

public class Test {
    private static void test(TestFunctionInterface functionInterface) {
        String v = functionInterface.test();
        System.out.println(v);
    }

    public static void main(String[] args) {
        test(
                new TestFunctionInterfaceImpl()
        );

        // 匿名内部类
        test(new TestFunctionInterface() {
            @Override
            public String test() {
                System.out.println("Anonymous class test method");
                return "c";
            }
        });

        // Lambda 表达式
        test(() -> {
            System.out.println("Lambda test method1");
            return "b";
        });

        // 如果只有一行, 可以省略大括号, return和末尾的分号
        test(() -> "a");
    }

}
