package com.assessment.store.discount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Checkout {
    private double totalCostOfGroceries;
    private double totalCostOfElectronics;
    private double totalCostOfHousehold;
    private double totalCostOfStationaries;

    public double totalCheckOut () {
        return this.totalCostOfGroceries + this.totalCostOfElectronics + this.totalCostOfHousehold + this.totalCostOfStationaries;
    }

    public double totalCheckOutWithoutGroceries () {
        return this.totalCostOfElectronics + this.totalCostOfHousehold + this.totalCostOfStationaries;
    }
}
