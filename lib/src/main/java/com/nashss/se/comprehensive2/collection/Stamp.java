package com.nashss.se.comprehensive2.collection;

import java.math.BigDecimal;

public class Stamp implements Collectable {
    private final BigDecimal value;

    public Stamp(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
