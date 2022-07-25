package com.nashss.se.comprehensive2.collection;

import java.math.BigDecimal;

public class Coin {
    private final BigDecimal faceValue;
    private final BigDecimal collectorValue;

    public Coin(BigDecimal faceValue, BigDecimal collectorValue) {
        this.faceValue = faceValue;
        this.collectorValue = collectorValue;
    }

    public BigDecimal getValue() {
        return faceValue.add(collectorValue);
    }
}
