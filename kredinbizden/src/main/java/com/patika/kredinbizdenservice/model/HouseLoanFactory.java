package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.List;

public class HouseLoanFactory implements LoanFactory {
    private static HouseLoanFactory instance;
    private HouseLoanFactory() {}

    public static HouseLoanFactory getInstance() {
        if (instance == null) {
            instance = new HouseLoanFactory();
        }
        return instance;
    }

    @Override
    public Loan createLoan() {
        return new HouseLoan();
    }

    @Override
    public Loan createLoan(BigDecimal amount, Integer installment, Double interestRate) {
        return new HouseLoan(amount, installment, interestRate);
    }
}
