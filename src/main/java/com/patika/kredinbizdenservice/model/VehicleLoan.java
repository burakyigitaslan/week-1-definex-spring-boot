package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.VehicleStatusType;

import java.math.BigDecimal;

public class VehicleLoan extends Loan {

    private LoanType loanType = LoanType.ARAC_KREDISI;
    private VehicleStatusType vehicleStatusType;

    public VehicleLoan() {

    }

    public VehicleLoan(BigDecimal amount, Integer installment, Double interestRate) {
        super(amount, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        //istediği kadar ödeme yapabilir.
    }
}
