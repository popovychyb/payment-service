package com.payment.model.enums;

import java.math.BigDecimal;

public enum Currency {
    UAH("Ukrainian hryvnia", "Kopiyka", '₴', new BigDecimal("0.028")),
    USD("United States dollar", "Cent", '$', new BigDecimal("1")),
    EUR("Euro", "Cent", '€', new BigDecimal("1.2135"));

    private final String name;
    private final Character symbol;
    private final String fractional;
    //Rates in currency units per U.S. dollar
    private final BigDecimal conversionRate;


    Currency(String name, String fractional, Character symbol, BigDecimal conversionRate) {
        this.name = name;
        this.symbol = symbol;
        this.fractional = fractional;
        this.conversionRate = conversionRate;
    }

    public String getName() {
        return name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public String getFractional() {
        return fractional;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }
}
