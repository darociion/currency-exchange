package com.domain.currencyexchange.models;

public record Pair(String base_code,
                   String target_code,
                   double conversion_rate,
                   double conversion_result) {
}
