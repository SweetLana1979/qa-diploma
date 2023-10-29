package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Data {
    @Value
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    static Faker faker = new Faker();
    static LocalDate today = LocalDate.now();
    static String validMonth = String.format("%tm", today.plusMonths(1));
    static String currentYear = String.format("%ty", today.plusYears(0));
    static String pastYear = String.format("%ty", today.minusYears(2));
    static String futureYear = String.format("%ty", today.plusYears(7));
    static String name = faker.name().firstName() + " " + faker.name().lastName();
    static String nonexistentMonth = Integer.toString(ThreadLocalRandom.current().nextInt(13, 20));
    static String cvv = Integer.toString(ThreadLocalRandom.current().nextInt(111, 999));

    public static CardData getApprovedCard() {
        return new CardData("4444 4444 4444 4441", validMonth, currentYear, name, cvv);
    }

    public static CardData getDeclinedCard() {
        return new CardData("4444 4444 4444 4442", validMonth, currentYear, name, cvv);
    }

    public static CardData getNonexistentCard() {
        return new CardData("4444 4444 4444 4443", validMonth, currentYear, name, cvv);
    }

    public static CardData getInvalidNumberCard() {
        return new CardData("4444 4444 4444 444", validMonth, currentYear, name, cvv);
    }

    public static CardData getNonexistentMonthCard() {
        return new CardData("4444 4444 4444 4441", nonexistentMonth, currentYear, name, cvv);
    }

    public static CardData getExpiredPeriodCard() {
        return new CardData("4444 4444 4444 4441", validMonth, pastYear, name, cvv);
    }
    public static CardData getInvalidHolderCard() {
        return new CardData("4444 4444 4444 4441", validMonth, currentYear, "&&& ***", cvv);
    }
    public static CardData getInvalidCVVCard() {
        return new CardData("4444 4444 4444 4441", validMonth, currentYear, name, "99");
    }
    public static CardData getNoNumberCard() {
        return new CardData("", validMonth, currentYear, name, cvv);
    }
    public static CardData getNoMonthCard() {
        return new CardData("4444 4444 4444 4441", "", currentYear, name, cvv);
    }
    public static CardData getNoYearCard() {
        return new CardData("4444 4444 4444 4441", validMonth, "", name, cvv);
    }
    public static CardData getNoHolderCard() {
        return new CardData("4444 4444 4444 4441", validMonth, currentYear, "", cvv);
    }
    public static CardData getNoCVVCard() {
        return new CardData("4444 4444 4444 4441", validMonth, currentYear, name, "");
    }
    public static CardData getZerosInNumberFieldCard() {
        return new CardData("0000 0000 0000 0000", validMonth, currentYear, name, cvv);
    }
    public static CardData getZerosInMonthFieldCard() {
        return new CardData("4444 4444 4444 4441", "00", currentYear, name, cvv);
    }
    public static CardData getZerosInYearFieldCard() {
        return new CardData("4444 4444 4444 4441", validMonth, "00", name, cvv);
    }
    public static CardData getZerosInCVVFieldCard() {
        return new CardData("4444 4444 4444 4441", validMonth, currentYear, name, "000");
    }
    public static CardData getLongValidityPeriodCard() {
        return new CardData("4444 4444 4444 4441", validMonth, futureYear, name, cvv);
    }
}
