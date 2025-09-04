package org.turing.interview.error.test01;

import java.math.BigDecimal;

public class OverdraftException extends Exception {
    private final BigDecimal amount;
    private final BigDecimal balance;

    public OverdraftException(BigDecimal amount, BigDecimal balance, String message) {
        super(message);
        this.amount = amount;
        this.balance = balance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
