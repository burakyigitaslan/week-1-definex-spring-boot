package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.List;

public class ConsumerLoanFactory implements LoanFactory{
    private static ConsumerLoanFactory instance;
    private ConsumerLoanFactory() {}

    public static ConsumerLoanFactory getInstance() {
        if (instance == null) {
            instance = new ConsumerLoanFactory();
        }
        return instance;
    }

    @Override
    public Loan createLoan() {
        return new ConsumerLoan();
    }

    @Override
    public Loan createLoan(BigDecimal amount, Integer installment, Double interestRate) {
        return new ConsumerLoan(amount, installment, interestRate);
    }
}
