package com.livatek;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ConvertCurrency {

    public static final String DKK = "DKK";
    public static final String NOK = "NOK";
    public static final String SEK = "SEK";
    public static final String GBP = "GBP";
    public static final String EUR = "EUR";

    private static final Map<String, BigDecimal> rates = new HashMap<>();

    static {
        rates.put(DKK, BigDecimal.ONE);
        rates.put(NOK, new BigDecimal("0.735"));
        rates.put(SEK, new BigDecimal("0.7023"));
        rates.put(GBP, new BigDecimal("8.9107"));
        rates.put(EUR, new BigDecimal("7.4307"));
    }

    public static BigDecimal convertCurrency(String inputCurrency, String outputCurrency, BigDecimal value) {
        BigDecimal rate = rates.get(inputCurrency)
                .divide(rates.get(outputCurrency), 10, RoundingMode.CEILING);
        return value.multiply(rate);
    }
}
