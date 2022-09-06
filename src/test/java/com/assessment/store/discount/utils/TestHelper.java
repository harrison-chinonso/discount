package com.assessment.store.discount.utils;


import com.assessment.store.discount.enums.RelationshipWithStore;
import com.assessment.store.discount.model.Checkout;
import com.assessment.store.discount.model.User;

import java.time.LocalDateTime;

public class TestHelper {
	public static User createUser() {
		return new User(3L, RelationshipWithStore.CUSTOMER, 3);
	}

	public static Checkout createCheckout() {
		return new Checkout(250, 300, 100, 130);
	}
}
