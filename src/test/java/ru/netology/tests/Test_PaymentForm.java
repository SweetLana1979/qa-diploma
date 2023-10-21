package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import ru.netology.db_entities.Data;
import ru.netology.pages.MainPage;

public class Test_PaymentForm {

    @Test
    public void buyWithApprovedCard() {
        MainPage mainPage = new MainPage();
        Data.CardData approvedCard = Data.getApprovedCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(approvedCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeSuccessNotification();
    }

    @Test
    public void buyWithDeclinedCard() {
        MainPage mainPage = new MainPage();
        Data.CardData declinedCard = Data.getDeclinedCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(declinedCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeNoSuccessNotification();
    }

    @Test
    public void buyWithNonexistentCard() {
        MainPage mainPage = new MainPage();
        Data.CardData nonexistentCard = Data.getNonexistentCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(nonexistentCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeNoSuccessNotification();
    }

    @Test
    public void buyWithInvalidNumberCard() {
        MainPage mainPage = new MainPage();
        Data.CardData invalidNumberCard = Data.getInvalidNumberCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(invalidNumberCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }

    @Test
    public void buyWithNonexistentMonthCard() {
        MainPage mainPage = new MainPage();
        Data.CardData nonexistentMonthCard = Data.getNonexistentMonthCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(nonexistentMonthCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongValidityPeriodNotification();
    }

    @Test
    public void buyWithExpiredPeriodCard() {
        MainPage mainPage = new MainPage();
        Data.CardData expiredPeriodCard = Data.getExpiredPeriodCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(expiredPeriodCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeExpiredPeriodNotification();
    }

    @Test
    public void buyWithInvalidHolderCard() {
        MainPage mainPage = new MainPage();
        Data.CardData invalidHolderCard = Data.getInvalidHolderCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(invalidHolderCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }

    @Test
    public void buyWithInvalidCVVCard() {
        MainPage mainPage = new MainPage();
        Data.CardData invalidCVVCard = Data.getInvalidCVVCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(invalidCVVCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }

    @Test
    public void buyWithNoNumberCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noNumberCard = Data.getNoNumberCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(noNumberCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }

    @Test
    public void buyWithNoMonthCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noMonthCard = Data.getNoMonthCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(noMonthCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }

    @Test
    public void buyWithNoYearCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noYearCard = Data.getNoYearCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(noYearCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }

    @Test
    public void buyWithNoHolderCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noHolderCard = Data.getNoHolderCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(noHolderCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeMandatoryFieldNotification();
    }

    @Test
    public void buyWithNoCVVCard() {
        MainPage mainPage = new MainPage();
        Data.CardData noCVVCard = Data.getNoCVVCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(noCVVCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }

    @Test
    public void buyWithZerosInNumberFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInNumberFieldCard = Data.getZerosInNumberFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(zerosInNumberFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeNoSuccessNotification();
    }
    @Test
    public void buyWithZerosInMonthFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInMonthFieldCard = Data.getZerosInMonthFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(zerosInMonthFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongFormatNotification();
    }
    @Test
    public void buyWithZerosInYearFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInYearFieldCard = Data.getZerosInYearFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(zerosInYearFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeExpiredPeriodNotification();
    }
    @Test
    public void buyWithZerosInCVVFieldCard() {
        MainPage mainPage = new MainPage();
        Data.CardData zerosInCVVFieldCard = Data.getZerosInCVVFieldCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(zerosInCVVFieldCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeSuccessNotification();
    }
    @Test
    public void buyWithLongValidityPeriodCard() {
        MainPage mainPage = new MainPage();
        Data.CardData longValidityPeriodCard = Data.getLongValidityPeriodCard();

        Selenide.open("http://localhost:8080");
        mainPage.clickBuyButton();
        mainPage.fillCardData(longValidityPeriodCard);
        mainPage.clickContinueButton();
        mainPage.shouldBeWrongValidityPeriodNotification();
    }
}



