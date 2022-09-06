package com.assessment.store.discount.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RelationshipWithStore {
    EMPLOYEE(30, "Employee"),
    AFFILIATE(10, "Affiliate"),
    CUSTOMER(5, "Customer"),
    ABOVE100(5, "billAbove100");

    private final Integer discountRateObtainable;
    private final String name;
}
