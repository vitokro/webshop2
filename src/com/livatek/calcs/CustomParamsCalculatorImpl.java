package com.livatek.calcs;

import com.livatek.ConvertCurrency;
import com.livatek.Type;
import com.livatek.Vat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static com.livatek.DefaultCustomParams.*;

public class CustomParamsCalculatorImpl implements CustomParamsCalculator {
    public static final String VAT = "vat";

    @Override
    public BigDecimal calculate(BigDecimal basePrice, Type type, Map<String, String> params) {
        BigDecimal vat = Vat.of(params.get(VAT), type);

        String inputCurrency = params.get(INPUT_CURRENCY);
        String outputCurrency = params.get(OUTPUT_CURRENCY);

        return ConvertCurrency.convertCurrency(inputCurrency, outputCurrency, basePrice.multiply(vat))
                .setScale(2, RoundingMode.CEILING);
    }
}
