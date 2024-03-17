package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class ApplicationHandler {
    private static ApplicationHandler instance;
    private List<Application> applications;

    private ApplicationHandler() {
        this.applications = new ArrayList<>();
    }

    public static ApplicationHandler getInstance() {
        if (instance == null) {
            instance = new ApplicationHandler();
        }
        return instance;
    }
    public void addApplication(Application application) {
        applications.add(application);
    }

    public User findUserAppliedMost(){
        Map<User, Integer> userNumberOfApplication = new HashMap<>();
        User userAppliedMost;

        for (Application application : applications) {
            User user = application.getUser();
            userNumberOfApplication.put(user, userNumberOfApplication.getOrDefault(user, 0) + 1);
        }
        userAppliedMost = Collections.max(userNumberOfApplication.entrySet(), Map.Entry.comparingByValue()).getKey();

        return userAppliedMost;
    }

    public Map<User, BigDecimal> findUserWithHighestLoanAmount(){
        User userWithHighestLoanAmount = null;
        BigDecimal highestLoanAmount = BigDecimal.ZERO;

        for (Application application : applications) {
            if (application.getLoan() != null && (application.getLoan().getAmount().compareTo(BigDecimal.ZERO) > 0)) {
                highestLoanAmount = application.getLoan().getAmount();
                userWithHighestLoanAmount = application.getUser();
            }
        }

        Map<User, BigDecimal> userAndLoanAmount= new HashMap<>();
        userAndLoanAmount.put(userWithHighestLoanAmount, highestLoanAmount);

        return userAndLoanAmount;
    }

    public List<Application> listApplicationsMadeInLastMonth() {
        List<Application> applicationsMadeInLastMonth = new ArrayList<>();
        LocalDateTime lastMonth = LocalDateTime.now().minusMonths(1);

        for (Application application : applications) {
            if (application.getLocalDateTime().isAfter(lastMonth)) {
                applicationsMadeInLastMonth.add(application);
            }
        }

        return applicationsMadeInLastMonth;
    }
}
