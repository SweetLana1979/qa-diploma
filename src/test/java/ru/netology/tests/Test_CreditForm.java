package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.pages.MainPage;

public class Test_CreditForm {
    @BeforeAll
    static void setupAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void buyOnCreditWithApprovedCard() {
        MainPage mainPage = new MainPage();
        Data.CardData approvedCard = Data.getApprovedCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(approvedCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeSuccessNotification();
    }

    @Test
    public void buyOnCreditWithDeclinedCard() {
        MainPage mainPage = new MainPage();
        Data.CardData declinedCard = Data.getDeclinedCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(declinedCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeNoSuccessNotification();
    }
    @Test
    public void buyOnCreditWithNonexistentCard() {
        MainPage mainPage = new MainPage();
        Data.CardData nonexistentCard = Data.getNonexistentCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(nonexistentCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeNoSuccessNotification();
    }
    @Test
    public void buyOnCreditWithInvalidNumberCard() {
        MainPage mainPage = new MainPage();
        Data.CardData invalidNumberCard = Data.getInvalidNumberCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(invalidNumberCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithNonexistentMonthCard() {
        MainPage mainPage = new MainPage();
        Data.CardData nonexistentMonthCard = Data.getNonexistentMonthCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(nonexistentMonthCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongValidityPeriodNotification();
    }
    @Test
    public void buyOnCreditWithExpiredPeriodCard() {
        MainPage mainPage = new MainPage();
        Data.CardData expiredPeriodCard = Data.getExpiredPeriodCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(expiredPeriodCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeExpiredPeriodNotification();
    }
    @Test
    public void buyOnCreditWithInvalidHolderCard() {
        MainPage mainPage = new MainPage();
        Data.CardData invalidHolderCard = Data.getInvalidHolderCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(invalidHolderCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithInvalidCVVCard() {
        MainPage mainPage = new MainPage();
        Data.CardData invalidCVVCard = Data.getInvalidCVVCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(invalidCVVCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithNoNumberCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noNumberCard = Data.getNoNumberCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(noNumberCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithNoMonthCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noMonthCard = Data.getNoMonthCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(noMonthCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithNoYearCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noYearCard = Data.getNoYearCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(noYearCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithNoHolderCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noHolderCard = Data.getNoHolderCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(noHolderCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeMandatoryFieldNotification();
    }
    @Test
    public void buyOnCreditWithNoCVVCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noCVVCard = Data.getNoCVVCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(noCVVCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithZerosInNumberFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInNumberFieldCard = Data.getZerosInNumberFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(zerosInNumberFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeNoSuccessNotification();
    }
    @Test
    public void buyOnCreditWithZerosInMonthFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInMonthFieldCard = Data.getZerosInMonthFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(zerosInMonthFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyOnCreditWithZerosInYearFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInYearFieldCard = Data.getZerosInYearFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(zerosInYearFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeExpiredPeriodNotification();
    }
    @Test
    public void buyOnCreditWithZerosInCVVFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInCVVFieldCard = Data.getZerosInCVVFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(zerosInCVVFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeSuccessNotification();
    }
    @Test
    public void buyOnCreditWithLongValidityPeriodCard() {
        MainPage mainPage = new MainPage();
        Data.CardData longValidityPeriodCard = Data.getLongValidityPeriodCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyOnCreditButton();
        mainPage.fillCardData(longValidityPeriodCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongValidityPeriodNotification();
    }

}
