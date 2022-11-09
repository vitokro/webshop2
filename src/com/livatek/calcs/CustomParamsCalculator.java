package com.livatek.calcs;

import com.livatek.Type;

import java.math.BigDecimal;
import java.util.Map;

public interface CustomParamsCalculator {

    BigDecimal calculate(BigDecimal basePrice, Type type, Map<String, String> params);

}
