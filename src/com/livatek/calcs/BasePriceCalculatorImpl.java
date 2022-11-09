package com.livatek.calcs;

import com.livatek.Type;

import java.math.BigDecimal;

public class BasePriceCalculatorImpl implements BasePriceCalculator{

    FreightCalculator freightCalculator;

    public BasePriceCalculatorImpl(FreightCalculator freightCalculator) {
        this.freightCalculator = freightCalculator;
    }


    @Override
    public BigDecimal calculate(long amount, BigDecimal price, Type type) {
        long freightCost = 0;
        if (type == Type.BOOK) {
            freightCost = freightCalculator.calculate(amount);
        }
        return price.multiply(BigDecimal.valueOf(amount)).add(BigDecimal.valueOf(freightCost));
    }
}
