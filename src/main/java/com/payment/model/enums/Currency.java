package com.payment.model.enums;

import java.math.BigDecimal;

public enum Currency {
    UAH("Ukrainian hryvnia", "Kopiyka",'₴', new BigDecimal("0.036")),
    USD("United States dollar",  "Cent", '$', new BigDecimal("1")),
    EUR("Euro", "Cent",'€', new BigDecimal("1.2135"));

    private String name;
    private Character symbol;
    private String fractional;
    //Rates in currency units per U.S. dollar
    private BigDecimal conversionRate;


    Currency(String name, String fractional, Character symbol, BigDecimal conversionRate) {
        this.name = name;
        this.symbol = symbol;
        this.fractional = fractional;
        this.conversionRate = conversionRate;
    }
}
