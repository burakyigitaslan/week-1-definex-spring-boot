package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.List;

public class VehicleLoanFactory implements LoanFactory{
    private static VehicleLoanFactory instance;
    private VehicleLoanFactory() {}

    public static VehicleLoanFactory getInstance() {
        if (instance == null) {
            instance = new VehicleLoanFactory();
        }
        return instance;
    }

    @Override
    public Loan createLoan() {
        return new VehicleLoan();
    }

    @Override
    public Loan createLoan(BigDecimal amount, Integer installment, Double interestRate) {
        return new VehicleLoan(amount, installment, interestRate);
    }
}
