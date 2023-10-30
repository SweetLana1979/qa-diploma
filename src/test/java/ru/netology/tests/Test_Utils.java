package ru.netology.tests;

import ru.netology.data.db_entities.CreditEntity;
import ru.netology.data.db_entities.PaymentEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.SQL.fetchCreditEntity;
import static ru.netology.data.SQL.fetchPaymentEntity;

public class Test_Utils {
    static void shouldHavePaymentEntityForApprovedCard() {
        PaymentEntity paymentEntity = fetchPaymentEntity();
        String expectedStatus = "APPROVED";
        assertEquals(expectedStatus, paymentEntity.getStatus());

    }

    static void shouldHavePaymentEntityForDeclinedCard() {
        PaymentEntity paymentEntity = fetchPaymentEntity();
        String expectedStatus = "DECLINED";
        assertEquals(expectedStatus, paymentEntity.getStatus());


    }
    static void shouldHaveCreditEntityForApprovedCard() {
        CreditEntity creditEntity = fetchCreditEntity();
        String expectedStatus = "APPROVED";
        assertEquals(expectedStatus, creditEntity.getStatus());


    }
    static void shouldHaveCreditEntityForDeclinedCard() {
        CreditEntity paymentEntity = fetchCreditEntity();
        String expectedStatus = "DECLINED";
        assertEquals(expectedStatus, paymentEntity.getStatus());


    }

}
