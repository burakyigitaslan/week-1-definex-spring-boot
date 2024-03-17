package com.patika.kredinbizdenservice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreditCardHandler {
    private static CreditCardHandler instance;
    private List<CreditCard> creditCards;

    private CreditCardHandler() {
        this.creditCards = new ArrayList<>();
    }

    public static CreditCardHandler getInstance() {
        if (instance == null) {
            instance = new CreditCardHandler();
        }
        return instance;
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    public List<CreditCard> sortCreditCardsByNumberOfCampaigns() {
        List<CreditCard> sortedCreditCards = new ArrayList<>(creditCards);
        Collections.sort(sortedCreditCards, (item1, item2) -> Integer.compare(item2.getCampaignList().size(), item1.getCampaignList().size()));
        sortedCreditCards.reversed();

        return sortedCreditCards;
    }
}
