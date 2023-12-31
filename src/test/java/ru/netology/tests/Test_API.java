package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.db_entities.CreditEntity;
import ru.netology.data.Data;
import ru.netology.data.db_entities.PaymentEntity;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.data.API.SendCreditRequest;
import static ru.netology.data.API.SendPaymentRequest;
import static ru.netology.data.Data.getApprovedCard;
import static ru.netology.data.Data.getDeclinedCard;
import static ru.netology.data.SQL.*;

public class Test_API {
    @BeforeAll
    static void setupAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void deleteDBAfterEachTest() {
        deleteDB();
    }

    @Test
    void buyWithApprovedCard() {
        // Check API
        Data.CardData validApprovedCard = getApprovedCard();
        String expected = "{\"status\":\"APPROVED\"}";
        String requestStatus = SendPaymentRequest(validApprovedCard); // JSON
        assertEquals(expected, requestStatus);

       }

    @Test
    void buyOnCreditWithApprovedCard() {
        // Check API
        Data.CardData validApprovedCard = getApprovedCard();
        String expected = "{\"status\":\"APPROVED\"}";
        String requestStatus = SendCreditRequest(validApprovedCard); // JSON
        assertEquals(expected, requestStatus);
        // Check DB
        CreditEntity creditEntity = fetchCreditEntity();
        String expectedStatus = "APPROVED";
        assertEquals(expectedStatus, creditEntity.getStatus());
    }

    @Test
    void buyWithDeclinedCard() {
        // Check API
        Data.CardData validDeclinedCard = getDeclinedCard();
        String expected = "{\"status\":\"DECLINED\"}";
        String requestStatus = SendPaymentRequest(validDeclinedCard); // JSON
        assertEquals(expected, requestStatus);
        // Check DB
        PaymentEntity paymentEntity = fetchPaymentEntity();
        String expectedStatus = "DECLINED";
        assertEquals(expectedStatus, paymentEntity.getStatus());


    }

    @Test
    void buyOnCreditWithDeclinedCard() {
        // Check API
        Data.CardData validDeclinedCard = getDeclinedCard();
        String expected = "{\"status\":\"DECLINED\"}";
        String requestStatus = SendCreditRequest(validDeclinedCard); // JSON
        assertEquals(expected, requestStatus);
        // Check DB
        CreditEntity creditEntity = fetchCreditEntity();
        String expectedStatus = "DECLINED";
        assertEquals(expectedStatus, creditEntity.getStatus());
    }

}
