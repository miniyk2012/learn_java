package org.turing.interview.lambda.test04;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> f = new Function<Integer,Integer>(){
            @Override
            public Integer apply(Integer a) {
                return a + 1;
            }
        };
        Integer result = changeInteger(1, f);
        System.out.println(result);
    }

    private static Integer changeInteger(Integer a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    @Test
    void demo1() {
        Function<Integer, Integer> f = a -> a + 1;
        Integer result = changeInteger(1, f);
        assertEquals(2, changeInteger(1, f));
    }
}
