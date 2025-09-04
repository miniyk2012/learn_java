package org.turing.interview.error.test01;

import java.io.IOException;
import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) throws IOException, OverdraftException {
//        test01();
//        test02();
        test03();
    }

    private static void test01() throws IOException {
//        throw new Exception("lala");
        throw new IOException("aa");
    }

    private static void test02() {
        throw new RuntimeException("lala");
    }

    private static void test03() throws OverdraftException {
        throw new OverdraftException(BigDecimal.valueOf(10),
                BigDecimal.valueOf(5), "余额不足");
    }


}

