package com.livatek;

import com.livatek.calcs.*;

import java.math.BigDecimal;
import java.util.Map;

import static com.livatek.DefaultCustomParams.OUTPUT_CURRENCY;


public class Main {

    public static void main(String[] args) {
        String totalPrice = getTotalPrice(args);
        System.out.println(totalPrice);
    }

    public static String getTotalPrice(String[] args) {
        validateParams(args);

        int amount = Integer.parseInt(args[0]);
        BigDecimal price = new BigDecimal(args[1]);
        Type type = Type.valueOf(args[2].toUpperCase());

        Map<String, String> customParams = getCustomParams(args);

        BasePriceCalculator baseCalc = new BasePriceCalculatorImpl(new FreightCalculatorImpl());
        BigDecimal basePrice = baseCalc.calculate(amount, price, type);

        CustomParamsCalculator calc = new CustomParamsCalculatorImpl();
        return calc.calculate(basePrice, type, customParams) + " " + customParams.get(OUTPUT_CURRENCY);
    }

    private static Map<String, String> getCustomParams(String[] args) {
        Map<String, String> customParams = new DefaultCustomParams().get();

        for (int i = 3; i < args.length; i++) {
            String[] strings = args[i].split("=");
            customParams.put(strings[0].substring(2), strings[1]);
        }
        return customParams;
    }

    private static void validateParams(String[] args) {
        // validations of input params
    }
}
