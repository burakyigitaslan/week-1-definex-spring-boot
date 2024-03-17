package com.onlineshoppingservice;

import com.onlineshoppingservice.enums.OrderStatus;
import com.onlineshoppingservice.enums.PaymentMethod;
import com.onlineshoppingservice.enums.ProductCategory;
import com.onlineshoppingservice.model.Customer;
import com.onlineshoppingservice.model.Invoice;
import com.onlineshoppingservice.model.Order;
import com.onlineshoppingservice.model.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("Cem","Sever", LocalDate.parse("08-02-1980", DateTimeFormatter.ofPattern("dd-MM-yyyy")),"cemsever@gmail.com","123456","05553216598","Ankara",true);
        Customer customer2 = new Customer("Burak","Ayan", LocalDate.parse("22-06-1992", DateTimeFormatter.ofPattern("dd-MM-yyyy")),"burakayan@gmail.com","456789","05334568956","Bursa",true);
        customers.add(customer1);
        customers.add(customer2);

        Product product1 = new Product("Telefon", ProductCategory.ELECTRONICS,42000.00,0.0,100,"Android Telefon","imageUrl1");
        Product product2 = new Product("Ayakkabı", ProductCategory.FOOTWEAR,3000.00,0.0,500,"Koşu Ayakkabısı","imageUrl2");
        Product product3 = new Product("Kazak", ProductCategory.CLOTHING,250.00,0.0,320,"Yün Kazak","imageUrl3");

        Order order1 = new Order(LocalDateTime.now(), PaymentMethod.CREDIT_CARD, OrderStatus.PENDING);
        Order order2 = new Order(LocalDateTime.now(), PaymentMethod.CASH_ON_DELIVERY, OrderStatus.PENDING);

        order1.addProduct(product1,1);
        order1.addProduct(product2,2);
        order2.addProduct(product2,1);
        order2.addProduct(product3,4);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        order1.setStatus(OrderStatus.CONFIRMED);
        order2.setStatus(OrderStatus.CONFIRMED);

        double order1TotalAmount = order1.calculateTotalAmount();
        double order2TotalAmount = order2.calculateTotalAmount();

        List<Invoice> invoices = new ArrayList<>();
        Invoice invoice1 = new Invoice(String.format("%s %s Sipariş Faturası",customer1.getName(), customer1.getSurname()),LocalDate.now(),order1TotalAmount);
        Invoice invoice2 = new Invoice(String.format("%s %s Sipariş Faturası",customer2.getName(), customer2.getSurname()),LocalDate.now(),order2TotalAmount);
        invoices.add(invoice1);
        invoices.add(invoice2);

        // Madde 1: Sistemdeki müşteri sayısı
        int totalNumberOfCustomers = customers.size();
        System.out.println("Sistemdeki toplam müşteri sayısı: "+totalNumberOfCustomers);

        // Madde 2: İsmi Cem olan müşterilerin aldıkları ürün sayısı
        int productCountOrderedByCem = 0;
        for (Customer customer: customers){
            if(customer.getName().equals("Cem")){
                for(Order order: customer.getOrderList()){
                    for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
                        Integer quantity = entry.getValue();
                        productCountOrderedByCem+=quantity;
                    }
                }
            }
        }
        System.out.println("İsmi Cem olan müşterilerin aldıkları ürün sayısı: "+productCountOrderedByCem);

        // Madde 3: İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı
        double totalAmountOrderedByCem = 0.0;
        for (Customer customer: customers){
            if(customer.getName().equals("Cem") && customer.calculateAge() > 25 && customer.calculateAge() < 30) {
                for(Order order:customer.getOrderList()){
                    totalAmountOrderedByCem += order.calculateTotalAmount();
                }
            }
        }
        System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı: "+totalAmountOrderedByCem);

        // Madde 4: Sistemdeki 1500 TL üzerindeki faturalar
        System.out.println("Sistemdeki 1500 TL üzerindeki faturaların listesi:");
        for (Invoice invoice : invoices) {
            if (invoice.getTotalAmount() > 1500){
                System.out.println(invoice.getName()+": Toplam Tutar = "+invoice.getTotalAmount());
            }
        }

    }
}
