package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KredinbizdenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KredinbizdenServiceApplication.class, args);

        HouseLoanFactory houseLoanFactory=HouseLoanFactory.getInstance();
        Loan houseLoan1 = houseLoanFactory.createLoan(BigDecimal.valueOf(255), 1,0.05);
        Loan houseLoan2 = houseLoanFactory.createLoan(BigDecimal.valueOf(355), 1,0.05);

        ConsumerLoanFactory consumerLoanFactory =ConsumerLoanFactory.getInstance();
        Loan consumerLoan = consumerLoanFactory.createLoan();

        VehicleLoanFactory vehicleLoanFactory=VehicleLoanFactory.getInstance();
        Loan vehicleLoan = vehicleLoanFactory.createLoan();

        User user1 = new User("Burak", "Yiğitaslan", "brk@gmail.com", "psw","tel",true);
        User user2 = new User("Ali", "Yiğitaslan", "ali@gmail.com", "","tel",true);

        String pass1 = user1.getPassword();
        System.out.println(pass1);

        user1.setPassword("aaaa");
        String pass1new = user1.getPassword();
        System.out.println(pass1new);
        String pass2=user2.getPassword();
        System.out.println(pass2);

        LocalDateTime time= LocalDateTime.now() ;

        ApplicationHandler applicationHandler = ApplicationHandler.getInstance();

        Application app1 = new Application( houseLoan1,  user1, time, applicationHandler);
        Application app2 = new Application( houseLoan2,  user2, time, applicationHandler);

        applicationHandler.findUserAppliedMost();
        applicationHandler.findUserWithHighestLoanAmount();
        applicationHandler.listApplicationsMadeInLastMonth();
        applicationHandler.getApplicationsByEmail("brk@gmail.com");
        applicationHandler.getApplicationsByEmail("ali@gmail.com");

        Campaign cmp1 = new Campaign();
        Campaign cmp2 = new Campaign();
        Campaign cmp3 = new Campaign();

        List<Campaign> cc1camp = new ArrayList<>();
        List<Campaign> cc2camp = new ArrayList<>();
        cc1camp.add(cmp1);
        cc2camp.add(cmp1);
        cc2camp.add(cmp2);
        cc2camp.add(cmp3);

        CreditCardHandler creditCardHandler = CreditCardHandler.getInstance();

        CreditCard creditCard1=new CreditCard(BigDecimal.valueOf(3),cc1camp,creditCardHandler);
        CreditCard creditCard2=new CreditCard(BigDecimal.valueOf(5),cc2camp,creditCardHandler);

        System.out.println(creditCard1.getCampaignList());
        creditCardHandler.sortCreditCardsByNumberOfCampaigns();
    }

}
