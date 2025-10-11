package com.demo.bank.Model;

import java.util.Map;

public record FxRatesResponse(
        boolean success,
        String date,
        String base,
        Map<String, Double> rates
) {}