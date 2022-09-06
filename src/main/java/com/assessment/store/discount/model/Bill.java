package com.assessment.store.discount.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bill {
    private double subTotal;
    private double discount;
    private double totalBill;
}
