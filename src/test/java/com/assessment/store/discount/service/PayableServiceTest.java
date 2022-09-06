package com.assessment.store.discount.service;

import com.assessment.store.discount.enums.RelationshipWithStore;
import com.assessment.store.discount.model.User;
import com.assessment.store.discount.utils.TestHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PayableServiceTest {

    @InjectMocks
    private PayableService payableService;

    @BeforeAll
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserIsEmployeeCorrectDiscount(){
        User user = TestHelper.createUser();
        user.setRelationshipWithStore(RelationshipWithStore.EMPLOYEE);
        double totalBillPayable = payableService.evaluateAmountPayable(user, TestHelper.createCheckout());
        assertThat(totalBillPayable).isEqualTo(621.0);
    }

    @Test
    void testUserIsEmployeeWrongDiscount(){
        User user = TestHelper.createUser();
        user.setRelationshipWithStore(RelationshipWithStore.EMPLOYEE);
        double totalBillPayable = payableService.evaluateAmountPayable(user, TestHelper.createCheckout());
        assertThat(totalBillPayable).isNotEqualTo(615.0);
    }

    @Test
    void testUserIsAffiliateCorrectDiscount(){
        User user = TestHelper.createUser();
        user.setRelationshipWithStore(RelationshipWithStore.AFFILIATE);
        double totalBillPayable = payableService.evaluateAmountPayable(user, TestHelper.createCheckout());
        assertThat(totalBillPayable).isEqualTo(727.0);
    }

    @Test
    void testUserIsAffiliateWrongDiscount(){
        User user = TestHelper.createUser();
        user.setRelationshipWithStore(RelationshipWithStore.AFFILIATE);
        double totalBillPayable = payableService.evaluateAmountPayable(user, TestHelper.createCheckout());
        assertThat(totalBillPayable).isNotEqualTo(722.0);
    }

    @Test
    void testUserIsCustomerLessThan2Years(){
        User user = TestHelper.createUser();
        user.setDurationOfRelationship(1);
        double totalBillPayable = payableService.evaluateAmountPayable(user, TestHelper.createCheckout());
        assertThat(totalBillPayable).isEqualTo(755.0);
    }

    @Test
    void testUserIsCustomerMoreThan2Years(){
        double totalBillPayable = payableService.evaluateAmountPayable(TestHelper.createUser(), TestHelper.createCheckout());
        assertThat(totalBillPayable).isEqualTo(753.5);
    }

    @Test
    void testEvery$100OnBillDiscount(){
        User user = TestHelper.createUser();
        user.setDurationOfRelationship(1);
        user.setRelationshipWithStore(RelationshipWithStore.ABOVE100);
        double totalBillPayable = payableService.evaluateAmountPayable(user, TestHelper.createCheckout());
        assertThat(totalBillPayable).isEqualTo(755.0);
    }

    @Test
    void testOnlyOnePercentageBasedDiscount(){
        User user = TestHelper.createUser();
        user.setDurationOfRelationship(3);
        user.setRelationshipWithStore(RelationshipWithStore.EMPLOYEE);
        double totalBillPayable = payableService.evaluateAmountPayable(user, TestHelper.createCheckout());
        assertThat(totalBillPayable).isEqualTo(621.0);
    }
}