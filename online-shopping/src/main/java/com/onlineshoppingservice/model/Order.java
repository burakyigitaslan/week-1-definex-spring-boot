package com.onlineshoppingservice.model;

import com.onlineshoppingservice.enums.OrderStatus;
import com.onlineshoppingservice.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private HashMap<Product, Integer> products;
    private LocalDateTime orderDate;
    private PaymentMethod paymentMethod;
    private OrderStatus status;
    private Invoice invoice;

    public Order(LocalDateTime orderDate, PaymentMethod paymentMethod, OrderStatus status) {
        this.products = new HashMap<>();
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Order(HashMap<Product, Integer> products, LocalDateTime orderDate, PaymentMethod paymentMethod, OrderStatus status) {
        this.products = products;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void addProduct(Product product, Integer quantity) {
        this.products.put(product,quantity);
    }

    public double calculateTotalAmount(){
        double totalAmount = 0.0;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Double price = entry.getKey().getPrice();
            Integer quantity = entry.getValue();
            totalAmount+=price*quantity;
        }
        return totalAmount;
    }

}
