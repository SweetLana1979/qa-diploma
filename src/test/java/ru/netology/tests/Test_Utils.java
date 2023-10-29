package ru.netology.tests;

import ru.netology.data.db_entities.PaymentEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.SQL.fetchPaymentEntity;

public class Test_Utils {
    static void shouldHavePaymentEntity() {
        PaymentEntity paymentEntity = fetchPaymentEntity();
        String expectedStatus = "APPROVED";
        String expectedAmount = "4500000";
        assertEquals(expectedStatus, paymentEntity.getStatus());
        assertEquals(expectedAmount, paymentEntity.getAmount());
    }
}
