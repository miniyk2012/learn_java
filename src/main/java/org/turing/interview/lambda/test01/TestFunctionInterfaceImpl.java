package org.turing.interview.lambda.test01;

public class TestFunctionInterfaceImpl implements TestFunctionInterface {
    @Override
    public String test() {
        System.out.println("TestFunctionInterfaceImpl test method");
        return "x";
    }
}
