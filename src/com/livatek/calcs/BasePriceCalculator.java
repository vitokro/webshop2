package com.livatek.calcs;

import com.livatek.Type;

import java.math.BigDecimal;

public interface BasePriceCalculator {

    BigDecimal calculate(long amount, BigDecimal price, Type type);
}
