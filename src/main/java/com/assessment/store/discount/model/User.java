package com.assessment.store.discount.model;

import com.assessment.store.discount.enums.RelationshipWithStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private long id;
    private RelationshipWithStore relationshipWithStore;
    private int durationOfRelationship;

    public String getRelationshipWithStore() {
        return relationshipWithStore.getName();
    }

    public Integer getDiscountRateObtainable() {
        List<String> exemptRelationship = Arrays.asList("Customer", "billAbove100");
        if(this.getRelationshipWithStore().equalsIgnoreCase("Customer") && durationOfRelationship > 2){
            return relationshipWithStore.getDiscountRateObtainable();
        }else if(!exemptRelationship.contains(this.getRelationshipWithStore())){
            return relationshipWithStore.getDiscountRateObtainable();
        }
        return 0;
    }
}
