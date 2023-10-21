package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.db_entities.Data;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private final SelenideElement buyOnCreditButton = $$("button").find(exactText("Купить в кредит"));
    private final SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("input[placeholder='08']");
    private final SelenideElement yearField = $("input[placeholder='22']");
    private final ElementsCollection fieldSet = $$(".input__control");
    private final SelenideElement cardholderField = fieldSet.get(3);
    private final SelenideElement cvvField = $("input[placeholder='999']");
    private final SelenideElement continueButton = $$("button").find(exactText("Продолжить"));
    private final SelenideElement successNotification = $(byText("Операция одобрена Банком."));
    private final SelenideElement noSuccessNotification = $(byText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement wrongFormatNotification = $(byText("Неверный формат"));
    private final SelenideElement wrongValidityPeriodNotification = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement expiredPeriodNotification = $(byText("Истёк срок действия карты"));
    private final SelenideElement mandatoryFieldNotification = $(byText("Поле обязательно для заполнения"));


    public void clickBuyButton() {buyButton.click();}
    public void clickBuyOnCreditButton() {buyOnCreditButton.click();}
    public void clickContinueButton() {continueButton.click();}

    public void fillCardData(Data.CardData cardData) {
        cardNumberField.setValue(cardData.getNumber());
        monthField.setValue(cardData.getMonth());
        yearField.setValue(cardData.getYear());
        cardholderField.setValue(cardData.getHolder());
        cvvField.setValue(cardData.getCvv());

    }
    public void shouldBeSuccessNotification() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public void shouldBeNoSuccessNotification() {
        noSuccessNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public void shouldBeWrongFormatNotification() {
        wrongFormatNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public void shouldBeWrongValidityPeriodNotification() {
        wrongValidityPeriodNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public void shouldBeExpiredPeriodNotification() {
        expiredPeriodNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public void shouldBeMandatoryFieldNotification() {
        mandatoryFieldNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    }












