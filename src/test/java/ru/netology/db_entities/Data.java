package ru.netology.db_entities;

import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
public class Data {
    @Value
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    public static CardData getApprovedCard() {
        return new CardData("4444 4444 4444 4441", "10", "24", "Ivan Ivanov", "999");
    }

    public static CardData getDeclinedCard() {
        return new CardData("4444 4444 4444 4442", "10", "24", "Ivan Ivanov", "999");
    }

    public static CardData getNonexistentCard() {
        return new CardData("4444 4444 4444 4443", "10", "24", "Ivan Ivanov", "999");
    }

    public static CardData getInvalidNumberCard() {
        return new CardData("4444 4444 4444 444", "10", "24", "Ivan Ivanov", "999");
    }

    public static CardData getNonexistentMonthCard() {
        return new CardData("4444 4444 4444 4441", "13", "24", "Ivan Ivanov", "999");
    }

    public static CardData getExpiredPeriodCard() {
        return new CardData("4444 4444 4444 4441", "12", "22", "Ivan Ivanov", "999");
    }
    public static CardData getInvalidHolderCard() {
        return new CardData("4444 4444 4444 4441", "12", "24", "&&& ***", "999");
    }
    public static CardData getInvalidCVVCard() {
        return new CardData("4444 4444 4444 4441", "12", "24", "Ivan Ivanov", "99");
    }
    public static CardData getNoNumberCard() {
        return new CardData("", "12", "24", "Ivan Ivanov", "999");
    }
    public static CardData getNoMonthCard() {
        return new CardData("4444 4444 4444 4441", "", "24", "Ivan Ivanov", "999");
    }
    public static CardData getNoYearCard() {
        return new CardData("4444 4444 4444 4441", "12", "", "Ivan Ivanov", "999");
    }
    public static CardData getNoHolderCard() {
        return new CardData("4444 4444 4444 4441", "12", "24", "", "999");
    }
    public static CardData getNoCVVCard() {
        return new CardData("4444 4444 4444 4441", "12", "24", "Ivan Ivanov", "");
    }
    public static CardData getZerosInNumberFieldCard() {
        return new CardData("0000 0000 0000 0000", "12", "24", "Ivan Ivanov", "999");
    }
    public static CardData getZerosInMonthFieldCard() {
        return new CardData("4444 4444 4444 4441", "00", "24", "Ivan Ivanov", "999");
    }
    public static CardData getZerosInYearFieldCard() {
        return new CardData("4444 4444 4444 4441", "12", "00", "Ivan Ivanov", "999");
    }
    public static CardData getZerosInCVVFieldCard() {
        return new CardData("4444 4444 4444 4441", "12", "24", "Ivan Ivanov", "000");
    }
    public static CardData getLongValidityPeriodCard() {
        return new CardData("4444 4444 4444 4441", "12", "30", "Ivan Ivanov", "999");
    }
}

