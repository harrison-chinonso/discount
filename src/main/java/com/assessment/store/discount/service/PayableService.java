package com.assessment.store.discount.service;

import com.assessment.store.discount.enums.RelationshipWithStore;
import com.assessment.store.discount.model.Bill;
import com.assessment.store.discount.model.Checkout;
import com.assessment.store.discount.model.User;
import org.springframework.stereotype.Service;

@Service
public class PayableService {

    public double evaluateAmountPayable(User user, Checkout checkout){
        double discount = checkout.totalCheckOutWithoutGroceries() * user.getDiscountRateObtainable()/100 ;

        if(discount < 1 && checkout.totalCheckOutWithoutGroceries() > 100){
            int multiplesOf100 = (int) (checkout.totalCheckOutWithoutGroceries()/100);
            discount = RelationshipWithStore.ABOVE100.getDiscountRateObtainable() * multiplesOf100;
        }

        double totalBillPayable = checkout.totalCheckOutWithoutGroceries() - discount + checkout.getTotalCostOfGroceries();
        Bill bill = new Bill(checkout.totalCheckOut(), discount, totalBillPayable);
        return bill.getTotalBill();
    }
}
