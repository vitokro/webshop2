package com.livatek;

import java.util.HashMap;
import java.util.Map;

import static com.livatek.ConvertCurrency.DKK;

public class DefaultCustomParams {
    public static final String INPUT_CURRENCY = "input-currency";
    public static final String OUTPUT_CURRENCY = "output-currency";

    private final Map<String, String> params = new HashMap<>();

    {
        params.put(INPUT_CURRENCY, DKK);
        params.put(OUTPUT_CURRENCY, DKK);
    }

    public Map<String, String> get() {
        return params;
    }
}
