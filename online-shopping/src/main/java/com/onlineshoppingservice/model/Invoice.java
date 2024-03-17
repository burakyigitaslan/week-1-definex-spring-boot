package com.onlineshoppingservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    private String name;
    private LocalDate invoiceDate;
    private Double totalAmount;

    public Invoice(String name, LocalDate invoiceDate, Double totalAmount) {
        this.name = name;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
